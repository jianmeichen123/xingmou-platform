package com.gi.xm.platform.newsmange.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/*
*
 * Created by vincent on 16-8-19.
 */


@SpringBootApplication
@ComponentScan(basePackages={"com.gi.xm.platform"})
public class NewsManageApp extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(NewsManageApp.class, args);
    }

}