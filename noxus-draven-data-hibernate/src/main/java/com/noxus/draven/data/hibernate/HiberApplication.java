package com.noxus.draven.data.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EntityScan("com.noxus.draven.data.hibernate.entity")
@SpringBootApplication
public class HiberApplication {
    public static void main(String[] args) {
        SpringApplication.run(HiberApplication.class, args);
    }
}
