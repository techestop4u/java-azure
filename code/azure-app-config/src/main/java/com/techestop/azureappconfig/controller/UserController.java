package com.techestop.azureappconfig.controller;


import com.techestop.azureappconfig.config.MessageConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

    @Autowired
    MessageConfig messageConfig;

    public UserController(MessageConfig messageConfig){
        this.messageConfig = messageConfig;
    }

    @GetMapping
    public ResponseEntity<String> getAllCustomers(){
        log.info("Get user details endpoint invoked.");
        log.info("Message retrieved: "+messageConfig.getMessage());
        return new ResponseEntity<String>(messageConfig.getMessage(), HttpStatus.OK);
    }
}
