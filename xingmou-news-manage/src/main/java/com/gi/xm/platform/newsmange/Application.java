package com.gi.xm.platform.newsmange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/*
*
 * Created by vincent on 16-8-19.
 */


@SpringBootApplication
@ComponentScan(basePackages={"com.gi.xm"})
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}