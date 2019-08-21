package com.icubespace.projects.cubeclound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CubecloundApplication {

    public static void main(String[] args) {
        SpringApplication.run(CubecloundApplication.class, args);
    }

}

