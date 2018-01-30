package com.gi.ctdn.api.main;

import com.gi.ctdn.api.conf.LoginFilter;
import com.gi.ctdn.config.SwaggerConfiguration;
import com.gi.ctdn.utils.BeanContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by vincent on 16-9-9.
 */

//@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages={"com.gi.ctdn"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Import(SwaggerConfiguration.class)
public class ApiRestApp {

    public static void main(String[] args) {
    	SpringApplication springApplication = new SpringApplication(ApiRestApp.class);
    	springApplication.run(args);
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
    	FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    	filterRegistrationBean.setFilter(new LoginFilter());
    	filterRegistrationBean.addUrlPatterns("/*");
    	return filterRegistrationBean;
    }

    @Bean
    public BeanContextUtils beanContextUtils() {
        return new BeanContextUtils();
    }
}