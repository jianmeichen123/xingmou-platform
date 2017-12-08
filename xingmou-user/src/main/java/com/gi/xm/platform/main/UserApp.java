package com.gi.xm.platform.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by vincent on 16-9-19.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.gi.xm.platform"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ImportResource(value = {"classpath*:application-bean.xml","classpath*:applicationContext-cache.xml","classpath*:dubbo/spring-consumer.xml"})//启动加在dubbo配置文件
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }
}
