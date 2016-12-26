package com.gi.xm.platform.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by vincent on 16-9-9.
 */

@SpringBootApplication
@ComponentScan(basePackages={"com.gi.xm"})
@ImportResource("classpath*:dubbo/spring-consumer.xml")//启动加在dubbo配置文件
public class DataRestApp {


    public static void main(String[] args) {
        SpringApplication.run(DataRestApp.class, args);
    }
}
