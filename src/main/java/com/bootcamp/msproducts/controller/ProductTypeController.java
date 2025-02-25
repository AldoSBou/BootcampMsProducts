package com.bootcamp.msproducts.controller;

import com.bootcamp.msproducts.model.ProductType;
import com.bootcamp.msproducts.service.IProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.net.URI;

@RequiredArgsConstructor
@Service
@RequestMapping("api/product/type")
public class ProductTypeController {

    private final IProductTypeService productTypeService;

    @PostMapping
    public Mono<ResponseEntity<ProductType>> insertProductType(@RequestBody ProductType productType, ServerHttpRequest request) {
        return productTypeService.save(productType)
                .map(result -> ResponseEntity.created(
                        URI.create(request.getURI().toString().concat("/").concat(result.getId()))
                ).contentType(MediaType.APPLICATION_JSON).body(result)
                ).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
