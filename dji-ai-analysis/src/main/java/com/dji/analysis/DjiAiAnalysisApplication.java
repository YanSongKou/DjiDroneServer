package com.dji.analysis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dji.analysis.mapper")
public class DjiAiAnalysisApplication {
    public static void main(String[] args) {
        SpringApplication.run(DjiAiAnalysisApplication.class, args);
    }
}
