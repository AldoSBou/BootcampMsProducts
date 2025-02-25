package com.bootcamp.msproducts.service;


import com.bootcamp.msproducts.model.ProductType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductTypeService extends IGenericService<ProductType,String> {
}
