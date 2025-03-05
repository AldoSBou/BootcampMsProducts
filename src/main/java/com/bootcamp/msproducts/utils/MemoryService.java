package com.bootcamp.msproducts.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class MemoryService implements IMemoryService{

    private final ReactiveRedisTemplate<String, Object> redisTemplate;

    @Override
    public Mono<Object> getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Mono<Boolean> saveValue(String key, Object value) {
        return redisTemplate.opsForValue().set(key, value);
    }
}
