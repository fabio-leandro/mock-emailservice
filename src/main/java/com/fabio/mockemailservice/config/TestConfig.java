package com.fabio.mockemailservice.config;

import com.fabio.mockemailservice.services.EmailService;
import com.fabio.mockemailservice.services.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
