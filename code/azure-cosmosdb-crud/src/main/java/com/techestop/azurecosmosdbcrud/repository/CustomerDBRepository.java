package com.techestop.azurecosmosdbcrud.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import com.techestop.azurecosmosdbcrud.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDBRepository extends CosmosRepository<Customer, String> {
    // Query for all documents
    @Query(value = "SELECT * FROM c")
    List<Customer> getAllCustomers();

}
