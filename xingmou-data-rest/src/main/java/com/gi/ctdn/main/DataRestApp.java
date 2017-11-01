package com.gi.ctdn.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by vincent on 16-9-9.
 */

@SpringBootApplication
@ComponentScan(basePackages={"com.gi.ctdn"})
public class DataRestApp {


    public static void main(String[] args) {
        SpringApplication.run(DataRestApp.class, args);
    }
}
