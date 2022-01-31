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

import java.util.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerDBRepository customerDBRepository;


    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    //Add new Customer
    @PostMapping
    public ResponseEntity<CustomerCrudResponse> createNewCustomer(@RequestBody Customer c){

        c = customerDBRepository.save(c);
        CustomerCrudResponse customerCrudResponse = new CustomerCrudResponse();
        customerCrudResponse.setMessage("New customer created successfully with the ID: "+c.getId());
        customerCrudResponse.setStatusCode("00");
        return new ResponseEntity<CustomerCrudResponse>(customerCrudResponse, HttpStatus.CREATED);
    }
    //Update existing Customer
    @PutMapping("/{id}")
    public ResponseEntity<String> updateExistingCustomer(@PathVariable String id,@RequestBody Customer c){

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
            List<Optional<Customer>> optionaCustomerList = Collections.singletonList(customerDBRepository.findById(id.get()));
            if(!(optionaCustomerList.get(0).isEmpty())){
                optionaCustomerList.stream().forEach( c -> c.ifPresent(customer -> customerList.add(customer)));
                return new ResponseEntity<List<Customer>>(customerList, responseHeaders, HttpStatus.OK);
            }

        }

        return new ResponseEntity<List<Customer>>(customerList, responseHeaders, HttpStatus.NOT_FOUND);

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
        Optional<Customer> customer  = customerDBRepository.findById(id);
        customerDBRepository.deleteById(id,new PartitionKey(customer.get().getLastName()));
        return new ResponseEntity<String>("", HttpStatus.NO_CONTENT);
    }
}
