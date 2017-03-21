package com.gi.xm.platform.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by vincent on 16-9-9.
 */

@SpringBootApplication
@ComponentScan(basePackages={"com.gi"})
public class DataRestApp {


    public static void main(String[] args) {
        SpringApplication.run(DataRestApp.class, args);
    }
}
