package com.techestop.azureappconfig;

import com.techestop.azureappconfig.config.MessageConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MessageConfig.class)
public class AzureAppConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureAppConfigApplication.class, args);
	}

}
