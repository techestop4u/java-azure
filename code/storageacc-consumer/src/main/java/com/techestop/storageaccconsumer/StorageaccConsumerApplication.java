package com.techestop.storageaccconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StorageaccConsumerApplication {

	public static void main(String[] args) {

		try{
			SpringApplication.run(StorageaccConsumerApplication.class, args);
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
