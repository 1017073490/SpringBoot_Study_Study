package com.zhangxing.springbootweb.config;

import com.zhangxing.springbootweb.entities.Employee_cache;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;
import java.util.List;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/6 14:09
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Employee_cache> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee_cache> template = new RedisTemplate<Object, Employee_cache>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<Employee_cache>(Employee_cache.class));
        return template;
    }

    @Bean
    public RedisCacheManager empCacheManager(RedisTemplate<Object, Employee_cache> empRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }

}
