package com.bootcamp.msproducts.service.impl;

import com.bootcamp.msproducts.model.ActiveProduct;
import com.bootcamp.msproducts.repository.IGenericRepository;
import com.bootcamp.msproducts.service.IProductActiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductActiveServiceImpl extends GenericServiceImpl<ActiveProduct,String> implements IProductActiveService {

    private final IGenericRepository<ActiveProduct,String> genericRepository;

    @Override
    protected IGenericRepository<ActiveProduct, String> getRepository() {
        return genericRepository;
    }
}
