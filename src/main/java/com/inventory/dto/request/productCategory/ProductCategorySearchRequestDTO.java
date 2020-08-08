package com.inventory.dto.request.productCategory;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author rupak ON 2020/08/08-10:53 PM
 */
@Getter
public class ProductCategorySearchRequestDTO implements Serializable {

    private String productCategoryName;

    private Long supplierId;

}
