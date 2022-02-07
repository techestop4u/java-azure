package com.techestop.azurecosmosdbcrud.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    @JsonProperty("AddressLine1")
    private String addressLine1;
    @JsonProperty("AddressLine2")
    private String addressLine2;
    @JsonProperty("AddressLine3")
    private String addressLine3;
    @JsonProperty("IsCurrentAddress")
    private String isCurrentAddress;
    @JsonProperty("IsPermanentAddress")
    private String isPermanentAddress;
    @JsonProperty("Pincode")
    private String pinCode;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
}
