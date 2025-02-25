package com.bootcamp.msproducts.mapper;

import com.bootcamp.msproducts.dto.PassiveProductDTO;
import com.bootcamp.msproducts.model.PassiveProduct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperPassiveProduct {

    @Qualifier("passiveProductMapper")
    private final ModelMapper productMapper;

    public PassiveProductDTO productToProductDTO(PassiveProduct passiveProduct) {
        return productMapper.map(passiveProduct, PassiveProductDTO.class);
    }

    public PassiveProduct convertToDocument(PassiveProductDTO passiveProductDTO) {
        return productMapper.map(passiveProductDTO, PassiveProduct.class);
    }
}
