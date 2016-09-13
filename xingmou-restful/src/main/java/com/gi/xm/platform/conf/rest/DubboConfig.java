package com.gi.xm.platform.conf.rest;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySources;

/**
 * Created by vincent on 16-8-25.
 */
@Configuration
public class DubboConfig {
    public static final String APPLICATION_NAME = "xm-service-rest";


    @Value("${dubbo.registry.address}")
    public static final String REGISTRY_ADDRESS = "zookeeper://127.0.0.1:2181";


    public static final String ANNOTATION_PACKAGE = "com.gi.xm.platform.controller";

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(APPLICATION_NAME);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(REGISTRY_ADDRESS);
        registryConfig.setCheck(false);


        return registryConfig;
    }

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setCheck(false);

        return consumerConfig;
    }

    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig = new ProviderConfig();

        providerConfig.setTimeout(120000);
        providerConfig.setRetries(0);

        return providerConfig;
    }
    @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(ANNOTATION_PACKAGE);
        return annotationBean;
    }
}
