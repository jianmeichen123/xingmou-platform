package com.gi.xm.platform.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * Created by vincent on 16-9-9.
 */

@SpringBootApplication
@ComponentScan(basePackages={"com.gi.xm.platform"})
@ImportResource("classpath*:dubbo/spring-consumer.xml")//启动加在dubbo配置文件
public class RestApp {


    public static void main(String[] args) {
        SpringApplication.run(RestApp.class, args);
    }
}
