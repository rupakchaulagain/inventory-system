package com.inventory.dto.request.product;

import lombok.*;

import java.io.Serializable;

/**
 * @author Rupak
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDTO implements Serializable {

    private String productName;

    private String productType;

    private String productCategory;

    private String productCode;

    private String productQuantity;

    private String productDescription;

    private Character status;

    private ProductPriceRequestDTO priceRequestDTO;

}
