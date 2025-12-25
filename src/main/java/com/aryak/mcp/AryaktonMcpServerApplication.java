package com.aryak.mcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AryaktonMcpServerApplication {

    static void main(String[] args) {
        SpringApplication.run(AryaktonMcpServerApplication.class, args);
    }

}
