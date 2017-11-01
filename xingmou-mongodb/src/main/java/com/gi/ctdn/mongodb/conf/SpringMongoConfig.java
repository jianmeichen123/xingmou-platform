package com.gi.ctdn.mongodb.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by vincent on 16-8-22.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.gi.ctdn")
public class SpringMongoConfig{


}