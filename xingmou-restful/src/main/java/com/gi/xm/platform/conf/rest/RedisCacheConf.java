package com.gi.xm.platform.conf.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;

/**
 * Created by vincent on 16-9-7.
 */
@Configuration
@EnableCaching
public class RedisCacheConf {

    @Bean
    public KeyGenerator reportKG(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append("xm-report:");
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(":");
                    if(obj instanceof  Integer[]){
                        Integer [] arr = ( Integer[] ) obj ;
                        StringBuffer b = new StringBuffer("[");
                        for (Integer str :arr){
                            b.append(str);
                            b.append(",");
                        }
                        b.setCharAt(b.length()-1,']');
                        sb.append(b);
                    }  else if(obj instanceof  Long[]){
                        Long [] arr = ( Long[] ) obj ;
                        StringBuffer b = new StringBuffer("[");
                        for (Long str :arr){
                            b.append(str);
                            b.append(",");
                        }
                        b.setCharAt(b.length()-1,']');
                        sb.append(b);
                    }else {
                        sb.append(obj.toString());
                    }
                }
                return sb.toString();
            }
        };

    }

    @Bean
    public KeyGenerator api(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append("xm-api:");
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(":");
                    if(obj instanceof  Integer[]){
                        Integer [] arr = ( Integer[] ) obj ;
                        StringBuffer b = new StringBuffer("[");
                        for (Integer str :arr){
                            b.append(str);
                            b.append(",");
                        }
                        b.setCharAt(b.length()-1,']');
                        sb.append(b);
                    }  else if(obj instanceof  Long[]){
                        Long [] arr = ( Long[] ) obj ;
                        StringBuffer b = new StringBuffer("[");
                        for (Long str :arr){
                            b.append(str);
                            b.append(",");
                        }
                        b.setCharAt(b.length()-1,']');
                        sb.append(b);
                    }else {
                        sb.append(obj.toString());
                    }
                }
                return sb.toString();
            }
        };

    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(300);
        return redisCacheManager;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
