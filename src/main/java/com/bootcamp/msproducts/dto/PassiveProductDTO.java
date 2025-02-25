package com.bootcamp.msproducts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassiveProductDTO {

    private String id;
    private ProductTypeDTO productType;
    private String status;
    private String productSubType;
    private Integer monthlyTransactionLimit;
    private BigDecimal maintenanceFee;

}