package com.techestop.storageaccconsumer.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BlobStorageService {





    public String processBlobFile(String blobName){

        // Create a BlobServiceClient object which will be used to get a container client

        try{


            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString("<connection-string>").buildClient();

            BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient("pratcontainer01");

            BlobClient blobClient = containerClient.getBlobClient(blobName);

            blobClient.downloadToFile("downloaded-file.txt",true);

            return "Success";
        }
        catch(Exception e){
            return "Failure -> "+e.getMessage();
        }


    }
}
