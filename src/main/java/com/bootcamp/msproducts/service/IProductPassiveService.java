package com.bootcamp.msproducts.service;


import com.bootcamp.msproducts.model.PassiveProduct;
import reactor.core.publisher.Mono;

public interface IProductPassiveService extends IGenericService<PassiveProduct,String> {
    Mono<PassiveProduct> getProductInformation(String productId);
}
