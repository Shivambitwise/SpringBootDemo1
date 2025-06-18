package com.shivam.productserivce.Springboot.ApplicationConfiguration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RestTemplate createRestTemplate()
    {
        return new RestTemplateBuilder().build();
    }
}
