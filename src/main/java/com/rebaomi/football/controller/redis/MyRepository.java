package com.rebaomi.football.controller.redis;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
    @Autowired
    private RedisTemplate<String, MyUser> template;

    private ValueOperations<String, MyUser> operations;

    
    @PostConstruct
    public void init() {
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(MyUser.class));
        operations = template.opsForValue();
    }

    public void set(String key, MyUser clazz) {
        operations.set(key, clazz);
    }

    public MyUser get(String key) {
        return operations.get(key);
    }

}
