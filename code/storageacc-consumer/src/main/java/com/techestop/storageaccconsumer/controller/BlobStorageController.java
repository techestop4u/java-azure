package com.techestop.storageaccconsumer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techestop.storageaccconsumer.service.BlobStorageService;

@RestController
public class BlobStorageController {


    @Autowired
    BlobStorageService blobStorageService;


    @PostMapping("/api/v1/storageblob")
    public ResponseEntity<String> getAndProcessBlob(@RequestParam String blobName){

        String status = blobStorageService.processBlobFile(blobName);

        if("Success".equalsIgnoreCase(status)){
            return ResponseEntity.ok("Blob file processed successfully");
        }
        else{

            return ResponseEntity.internalServerError().body("Error in processing blob file");
        }


    }
}


