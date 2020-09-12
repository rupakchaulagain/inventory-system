package com.inventory.dto.response.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Rupak
 */
@Getter
@Setter
public class ProductMinimalResponseDTO implements Serializable {

    private Long id;

    private String productName;

    private String productCategory;

    private String productType;

    private Long productQuantity;

    private Double costPrice;

    private Double sellingPrice;

    private Character status;

}
