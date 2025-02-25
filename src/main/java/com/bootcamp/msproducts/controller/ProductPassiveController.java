package com.bootcamp.msproducts.controller;

import com.bootcamp.msproducts.dto.PassiveProductDTO;
import com.bootcamp.msproducts.mapper.MapperPassiveProduct;
import com.bootcamp.msproducts.service.IProductPassiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("api/products/passive")
@RequiredArgsConstructor
public class ProductPassiveController {

    private final IProductPassiveService productService;

    @Qualifier("passiveProductMapper")
    private final MapperPassiveProduct mapperPassiveProduct;

    @GetMapping
    Mono<ResponseEntity<Flux<PassiveProductDTO>>> findAll() {

        Flux<PassiveProductDTO> list = productService.findAll()
                .map(mapperPassiveProduct::productToProductDTO);

        return Mono.just(ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(list)
                ).defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @GetMapping("/{id}")
    Mono<ResponseEntity<PassiveProductDTO>> findById(@PathVariable String id) {
        return productService.getProductInformation(id)
                .map(mapperPassiveProduct::productToProductDTO)
                .map(e -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(e)
                ).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    Mono<ResponseEntity<PassiveProductDTO>> insertProduct(@RequestBody PassiveProductDTO passiveProductDTO, final ServerHttpRequest request) {

        return productService.save(mapperPassiveProduct.convertToDocument(passiveProductDTO))
                .map(mapperPassiveProduct::productToProductDTO)
                .map(result ->
                      ResponseEntity.created(URI.create(request.getURI().toString().concat("/").concat(result.getId())))
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(result)
                ).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
