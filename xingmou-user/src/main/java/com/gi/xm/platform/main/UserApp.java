package com.gi.xm.platform.main;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

/**
 * Created by vincent on 16-9-19.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.gi.xm.platform"})
@MapperScan("com.gi.xm.platform.dao")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ImportResource(value = {"classpath*:application-bean.xml","classpath*:applicationContext-cache.xml","classpath*:dubbo/spring-consumer.xml"})//启动加在dubbo配置文件
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }
    @ConfigurationProperties(prefix="spring.datasource")
    @Bean(name = "dataSourceBase")
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
    
    @Bean(name = "sqlSessionFactoryBase")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
//        bean.setTypeAliasesPackage("com.gi.xm.platform.dao");
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        //properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        bean.setPlugins(new Interceptor[]{pageHelper});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:sql-map-base/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "sqlSessionTemplateBase")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryBase") SqlSessionFactory sqlSessionFactoryBase) {
        return new SqlSessionTemplate(sqlSessionFactoryBase);
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }
}
