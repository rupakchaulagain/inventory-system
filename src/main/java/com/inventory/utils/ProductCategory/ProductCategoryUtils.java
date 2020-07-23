package com.inventory.utils.ProductCategory;

import com.inventory.dto.request.productCategory.ProductCategoryRequestDTO;
import com.inventory.model.ProductCategory;
import com.inventory.model.Supplier;

/**
 * @author rupak ON 2020/07/23-8:23 PM
 */
public class ProductCategoryUtils {

    public static ProductCategory parseToProductCategory(ProductCategoryRequestDTO requestDTO,
                                                         Supplier supplier) {

        return ProductCategory.builder()
                .name(requestDTO.getProductCategoryName())
                .description(requestDTO.getProductCategoryDescription())
                .status(requestDTO.getStatus())
                .supplier(supplier)
                .build();

    }
}
