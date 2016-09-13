package com.gi.xm.platform.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by vincent on 16-9-9.
 */
@ImportResource("classpath*:dubbo/spring-consumer.xml")//启动加在dubbo配置文件
@SpringBootApplication
@ComponentScan(basePackages={"com.gi.xm.platform"})
public class RestApp {

    public static void main(String[] args) {
        SpringApplication.run(RestApp.class, args);
    }
}
