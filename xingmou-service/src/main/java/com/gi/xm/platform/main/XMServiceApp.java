
package com.gi.xm.platform.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(basePackages = {"com.gi.xm"})
@EnableAutoConfiguration//启用自动配置
@SpringBootApplication
@ImportResource("classpath*:dubbo/spring-provider.xml")//启动加在dubbo配置文件
public class XMServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(XMServiceApp.class, args);

    }
}

