package com.dstation.dstation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dstation.dstation.dao")
public class DstationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DstationApplication.class, args);
    }

}
