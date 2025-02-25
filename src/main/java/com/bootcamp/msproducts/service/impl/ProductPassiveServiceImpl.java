package com.bootcamp.msproducts.service.impl;

import com.bootcamp.msproducts.model.PassiveProduct;
import com.bootcamp.msproducts.repository.IGenericRepository;
import com.bootcamp.msproducts.repository.IProductPassiveRepository;
import com.bootcamp.msproducts.repository.IProductTypeRepository;
import com.bootcamp.msproducts.service.IProductPassiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ProductPassiveServiceImpl extends GenericServiceImpl<PassiveProduct,String> implements IProductPassiveService {

    private final IProductPassiveRepository productRepository;
    private final IProductTypeRepository productTypeRepository;

    @Override
    protected IGenericRepository<PassiveProduct, String> getRepository() {
        return productRepository;
    }

    @Override
    public Flux<PassiveProduct> findAll() {
        return productRepository.findAll()
                .flatMap(result -> {
                    return productTypeRepository.findById(result.getProductType().getId())
                            .map(productType -> {
                                result.setProductType(productType);
                                return result;
                            });
                });
    }

    @Override
    public Mono<PassiveProduct> getProductInformation(String productId) {
        return findAll().filter(result -> result.getId().equals(productId)).next();
    }
}
