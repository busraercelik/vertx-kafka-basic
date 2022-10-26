package com.bsr.coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConsumerAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerAppApplication.class, args);
    }
}
