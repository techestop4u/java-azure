package com.techestop.azurecosmosdbcrud;


import com.azure.cosmos.models.PartitionKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/customers")
public class CustomerController {

    @Autowired
    CustomerDBRepository customerDBRepository;

    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    //Add new Customer
    @PostMapping
    public ResponseEntity<String> createNewCustomer(@RequestBody Customer c){

        customerDBRepository.save(c);
        return new ResponseEntity<String>("", HttpStatus.CREATED);
    }
    //Update existing Customer
    @PutMapping
    public ResponseEntity<String> updateExistingCustomer(@RequestBody Customer c){

        customerDBRepository.save(c);
        return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }


    //get customer details
    @GetMapping("/{id}")
    public ResponseEntity<List<Customer>> getCustomers(@PathVariable Optional<String> id){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("ContentType","application/json");
        List<Customer> customerList = new ArrayList<>();
        if(id.isPresent()){
            logger.info("Id is present in the GET request");
            String[] keys = id.get().split("-");
            customerList = Collections.singletonList(customerDBRepository.findById(keys[0],new PartitionKey(keys[1])).get());

        }

        return new ResponseEntity<List<Customer>>(customerList, responseHeaders, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("ContentType","application/json");
        List<Customer> customerList = new ArrayList<>();

        logger.info("Id is not present in the GET request");
        customerList = customerDBRepository.getAllCustomers();
        return new ResponseEntity<List<Customer>>(customerList, responseHeaders, HttpStatus.OK);

    }

    //delete the customer of a particular id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExistingCustomer(@PathVariable String id){
        String[] keys = id.split("-");

        customerDBRepository.deleteById(keys[0],new PartitionKey(keys[1]));
        return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }
}
