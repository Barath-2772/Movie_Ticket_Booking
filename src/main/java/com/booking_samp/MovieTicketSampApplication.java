package com.booking_samp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {
    "com.booking_samp_repository" 
})
@EntityScan(basePackages = {
    "com.booking_samp_modal"
})
@ComponentScan(basePackages = {
    "com.booking_samp", 
    "com.booking_samp_controller", 
    "com.booking_samp_service", 
    "com.booking_samp_repository",
    "com.booking_samp_modal",
    "com.booking_samp_dto",
    "com.booking_samp_config"
})
public class MovieTicketSampApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieTicketSampApplication.class, args);
    }
}