package com.xieyv.lighthome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebAppApplication {
    public static void main(String[] args) {
        System.out.println("hello app");
        SpringApplication.run(WebAppApplication.class, args);
    }
}
