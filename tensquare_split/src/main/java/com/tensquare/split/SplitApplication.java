package com.tensquare.split;

import com.sun.glass.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@SpringBootApplication
public class SplitApplication {
    public static void main(String[] args) {
        SpringApplication.run(SplitApplication.class);
    }

    @Bean
    public IdWorker idWorker()
    {
        return new IdWorker(1,1);
    }
}
