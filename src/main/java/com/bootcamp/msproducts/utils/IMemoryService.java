package com.bootcamp.msproducts.utils;

import reactor.core.publisher.Mono;

public interface IMemoryService {
    Mono<Object> getValue (String key);
    Mono<Boolean> saveValue(String key, Object value);
}
