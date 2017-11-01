package com.gi.ctdn.api.main;

import com.gi.ctdn.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by vincent on 16-9-9.
 */

@SpringBootApplication
@ComponentScan(basePackages={"com.gi.ctdn"})
@Import(SwaggerConfiguration.class)
public class ApiRestApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestApp.class, args);
    }
}