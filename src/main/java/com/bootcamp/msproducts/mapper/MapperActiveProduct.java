package com.bootcamp.msproducts.mapper;


import com.bootcamp.msproducts.dto.ActiveProductDTO;
import com.bootcamp.msproducts.model.ActiveProduct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperActiveProduct {

    @Qualifier("activeProductMapper")
    private final ModelMapper activeMapper;

    public ActiveProductDTO productToProductDTO(ActiveProduct passiveProduct) {
        return activeMapper.map(passiveProduct, ActiveProductDTO.class);
    }

    public ActiveProduct convertToDocument(ActiveProductDTO passiveProductDTO) {
        return activeMapper.map(passiveProductDTO, ActiveProduct.class);
    }
}
