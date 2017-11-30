package com.gi.ctdn.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by vincent on 16-9-9.
 */

@SpringBootApplication
@ComponentScan(basePackages={"com.gi.ctdn"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DataRestApp {


    public static void main(String[] args) {
        SpringApplication.run(DataRestApp.class, args);
    }
}
