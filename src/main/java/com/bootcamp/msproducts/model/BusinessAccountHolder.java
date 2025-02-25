package com.bootcamp.msproducts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "business_account_holders")
public class BusinessAccountHolder {

    @Id
    private String id;

    @Field("productId")
    private String productId; // Referencia a PassiveProduct (Cuenta Corriente Empresarial - ObjectId como String)

    @Field("clientId")
    private String clientId; // Referencia a Client

    @Field("holderType")
    private String holderType; // 'Titular' o 'Firmante Autorizado'
}
