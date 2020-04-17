package com.kind1ess.newsspider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NewsSpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsSpiderApplication.class, args);
    }

}
