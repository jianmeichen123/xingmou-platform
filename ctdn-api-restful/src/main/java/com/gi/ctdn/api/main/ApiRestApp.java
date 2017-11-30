package com.gi.ctdn.api.main;

import com.gi.ctdn.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by vincent on 16-9-9.
 */

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages={"com.gi.ctdn"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Import(SwaggerConfiguration.class)
public class ApiRestApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestApp.class, args);
    }
}