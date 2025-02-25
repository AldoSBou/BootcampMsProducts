package com.bootcamp.msproducts.service.impl;

import com.bootcamp.msproducts.model.ProductType;
import com.bootcamp.msproducts.repository.IGenericRepository;
import com.bootcamp.msproducts.repository.IProductTypeRepository;
import com.bootcamp.msproducts.service.IProductTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductTypeServiceImpl extends GenericServiceImpl<ProductType,String> implements IProductTypeService {

    private final IProductTypeRepository productTypeRepository;

    @Override
    protected IGenericRepository<ProductType, String> getRepository() {
        return productTypeRepository;
    }
}
