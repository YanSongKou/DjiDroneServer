package com.dji.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dji.business.mapper")
public class DjiBusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(DjiBusinessApplication.class, args);
    }
}
