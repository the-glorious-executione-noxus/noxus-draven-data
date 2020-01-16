package com.noxus.draven.tk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.noxus.draven.tk.mappers")
@SpringBootApplication
public class TkMyBatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(TkMyBatisApplication.class, args);
    }
}
