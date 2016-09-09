package com.gi.xm.platform.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by vincent on 16-9-9.
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.gi.xm.platform"})
public class RestApp {

    public static void main(String[] args) {
        SpringApplication.run(RestApp.class, args);
    }
}
