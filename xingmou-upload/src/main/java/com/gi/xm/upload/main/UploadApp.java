package com.gi.xm.upload.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by vincent on 16-9-9.
 */

@SpringBootApplication
@ComponentScan(basePackages={"com.gi.xm.upload"})
public class UploadApp {


    public static void main(String[] args) {
        SpringApplication.run(UploadApp.class, args);
    }
}
