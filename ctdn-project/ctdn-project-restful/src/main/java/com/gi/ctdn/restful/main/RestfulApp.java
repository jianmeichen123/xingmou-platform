package com.gi.ctdn.restful.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zcy on 17-2-17.
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.gi.ctdn"})
public class RestfulApp {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApp.class, args);
    }
}
