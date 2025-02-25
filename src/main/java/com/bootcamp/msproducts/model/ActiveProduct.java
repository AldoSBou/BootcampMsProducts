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
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "active_products")
public class ActiveProduct {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Field("productTypeId")
    private ProductType productType;

    @Field("status")
    private String status;

    @Field("productSubType")
    private String productSubType;

}
