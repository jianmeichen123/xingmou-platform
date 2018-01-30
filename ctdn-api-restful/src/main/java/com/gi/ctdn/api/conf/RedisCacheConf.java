package com.gi.ctdn.api.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxyinternet.framework.cache.Cache;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import org.springframework.beans.factory.annotation.Value;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vincent on 16-9-7.
 */
@Configuration
@EnableCaching
public class RedisCacheConf {

	private static final int maxTotal = 2000;
	private static final int maxIdle = 50;
	private static final int maxWaitMillis = 1000;
	private static final boolean testOnBorrow = true;

	@Value("${spring.redis.host}")
	private volatile String host;
	@Value("${spring.redis.port}")
	private volatile int port;
	@Value("${spring.redis.password}")
	private volatile String password;

    @Bean
    public KeyGenerator baseKG(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append("ctdn-base:");
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

    @Bean(name="stringRedisTemplate")
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

    @Bean
	public JedisPoolConfig jedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxTotal(maxTotal);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisPoolConfig.setTestOnBorrow(testOnBorrow);
		return jedisPoolConfig;
	}

	@Bean
	public  JedisShardInfo jedisShardInfo(){
		JedisShardInfo jedisShardInfo = new JedisShardInfo(host,port);
		jedisShardInfo.setPassword(password);
		return jedisShardInfo;
	}

	@Bean
	@SuppressWarnings("resource")
	public ShardedJedis ShardedJedis(){
		List<JedisShardInfo> jShardInfos = new ArrayList<JedisShardInfo>();
		jShardInfos.add(jedisShardInfo());
		ShardedJedisPool pool = new ShardedJedisPool(jedisPoolConfig(),jShardInfos);
		ShardedJedis  shardedJedis = pool.getResource();
		return shardedJedis;
	}
}
