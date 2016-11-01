package com.gi.xm.doc.restful.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by vincent on 16-10-27.
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.gi.xm"})
public class DocRestfulApp {

    public static void main(String[] args) {
        SpringApplication.run(DocRestfulApp.class, args);
    }
}
