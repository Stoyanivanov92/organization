package com.example.organization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Scanner scan() {
        return new Scanner(System.in);
    }
}
