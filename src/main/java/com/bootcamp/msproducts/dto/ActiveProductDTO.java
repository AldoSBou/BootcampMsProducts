package com.bootcamp.msproducts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveProductDTO {

    private String id;
    private ProductTypeDTO productType;
    private String status;
    private String productSubType;
}
