/*
package com.gi.xm.platform.conf.service;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

*/
/**
 * Created by vincent on 16-9-12.
 *//*


@Configuration
@Component
@Import(XMServiceConf.class)
public class Provider {

    @Resource
    private DubboConfig dubboConfig;

    @Bean
    public ApplicationConfig applicationConfig() {
        System.out.print("dubboConfig="+dubboConfig);
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(dubboConfig.APPLICATION_NAME);
        applicationConfig.setLogger("slf4j");

        System.out.print("------------------------------------------");
        System.out.print(dubboConfig.APPLICATION_NAME);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(dubboConfig.REGISTRY_ADDRESS);
        registryConfig.setProtocol("dubbo");
        registryConfig.setPort(dubboConfig.PORT);

        return registryConfig;
    }

    @Bean
    public AnnotationBean annotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(dubboConfig.BASEB_ACKAGE);
        return annotationBean;
    }

}
*/
