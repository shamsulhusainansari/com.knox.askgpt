package com.knox.askgpt.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
@ConfigurationProperties(prefix = "open-api")
public class OpenApiProperties {

    private Url url;
    private String key;
    private String model;

    @Data
    public static class Url {
        private String baseUrl;
        private String response;
    }
}