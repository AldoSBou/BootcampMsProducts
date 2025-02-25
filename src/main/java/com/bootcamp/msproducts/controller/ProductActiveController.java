package com.bootcamp.msproducts.controller;

import com.bootcamp.msproducts.dto.ActiveProductDTO;
import com.bootcamp.msproducts.mapper.MapperActiveProduct;
import com.bootcamp.msproducts.service.IProductActiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/products/active")
@RequiredArgsConstructor
public class ProductActiveController {

    private final IProductActiveService productActiveService;
    private final MapperActiveProduct mapper;

    @PostMapping
    Mono<ResponseEntity<ActiveProductDTO>> createActiveProduct(@RequestBody ActiveProductDTO activeProductDTO) {

        return productActiveService.save(mapper.convertToDocument(activeProductDTO))
                .map(mapper::productToProductDTO)
                .map(result -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(result)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    Mono<ResponseEntity<Flux<ActiveProductDTO>>> getAllActiveProducts() {

        Flux<ActiveProductDTO> list = productActiveService.findAll()
                .map(mapper::productToProductDTO);

        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(list)).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
