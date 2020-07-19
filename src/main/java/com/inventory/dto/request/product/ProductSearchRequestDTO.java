package com.inventory.dto.request.product;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author Rupak
 */
@Getter
public class ProductSearchRequestDTO implements Serializable {

    private String productName;

    private String productCategory;

    private String productType;

    private String productCode;
}
