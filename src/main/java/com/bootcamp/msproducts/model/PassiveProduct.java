package com.bootcamp.msproducts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "passive_products")
public class PassiveProduct {

    @Id
    private String id;

    @Field("productTypeId")
    private ProductType productType;

    @Field("status")
    private String status;

    @Field("productSubType")
    private String productSubType;

    @Field("monthlyTransactionLimit")
    private Integer monthlyTransactionLimit;

    @Field("maintenanceFee")
    private BigDecimal maintenanceFee;
}
