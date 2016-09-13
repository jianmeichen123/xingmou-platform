/*
package com.gi.xm.platform.conf.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

*/
/**
 * Created by vincent on 16-9-12.
 *//*

@Configuration
@Component
public class XMServiceConf {


    @Value("${spring.datasource.username}")
    protected volatile  String APPLICATION_NAME ;


    @Value("${dubbo.registry.address}")
    protected volatile   String REGISTRY_ADDRESS ;


    @Value("${dubbo.scan.basebackage}")
    protected volatile  String BASEB_ACKAGE;

    @Value("${dubbo.protocol.dubbo.port}")
    protected volatile  Integer PORT ;

    @Bean
    public DubboConfig dubboConfig(){
        DubboConfig dubboConfig = new DubboConfig();
        dubboConfig.setAPPLICATION_NAME(APPLICATION_NAME);
        dubboConfig.setREGISTRY_ADDRESS(REGISTRY_ADDRESS);
        dubboConfig.setBASEB_ACKAGE(BASEB_ACKAGE);
        dubboConfig.setPORT(PORT);
        return  dubboConfig;
    }
}
*/
