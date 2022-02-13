package com.techestop.azureappconfig.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Getter
@Setter
@ConfigurationProperties(prefix = "appconfig")
@RefreshScope
public class MessageConfig {
    private String message;
}
