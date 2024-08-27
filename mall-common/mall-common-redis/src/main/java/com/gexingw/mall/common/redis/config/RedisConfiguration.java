package com.gexingw.mall.common.redis.config;

import com.alibaba.fastjson2.support.spring.data.redis.GenericFastJsonRedisSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * mall-user-service
 *
 * @author GeXingW
 * @date 2024/2/17 18:54
 */
@Configuration
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class RedisConfiguration {

    private final RedisSerializer<String> keySerializer;
    private final RedisSerializer<Object> valueSerializer;

    /**
     * Key序列化
     *
     * @return StringRedisSerializer
     */
    @Bean("keySerializer")
    public RedisSerializer<String> keySerializer() {
        return new StringRedisSerializer();
    }

    /**
     * Value序列化
     *
     * @return GenericFastJsonRedisSerializer
     */
    @Bean("valueSerializer")
    public RedisSerializer<Object> valueSerializer() {
        return new GenericFastJsonRedisSerializer();
    }

    @Bean
    @Primary
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setValueSerializer(valueSerializer);
        redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setHashValueSerializer(valueSerializer);

        return redisTemplate;
    }

    @Bean("javaSerializerRedisTemplate")
    public RedisTemplate<String, Object> javaSerializerRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setValueSerializer(RedisSerializer.java());
        redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setHashValueSerializer(RedisSerializer.java());

        return redisTemplate;
    }

}
