package com.gi.xm.platform.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by vincent on 16-9-6.
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.gi.xm"})
@ImportResource("classpath*:galaxy-dubbo-consumer.xml")//启动加在dubbo配置文件
public class AuthApp extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(AuthApp.class, args);
    }
}
