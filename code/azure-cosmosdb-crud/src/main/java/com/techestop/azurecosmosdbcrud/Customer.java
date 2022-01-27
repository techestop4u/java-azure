package com.techestop.azurecosmosdbcrud;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;


@Getter
@Setter
@Container(containerName = "Customer", ru = "400")
public class Customer {

    @Id
    private int id;
    private String firstName;

    @PartitionKey
    private String lastName;
    private String contactNumber;
    private List<Address> addresses;

    public Customer(int Id, String firstName, String lastName, String contactNumber, List<Address> addresses){
        this.id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.addresses = addresses;
    }


}