package com.inventory.utils;

import com.inventory.constants.StatusConstants;
import com.inventory.dto.request.productSale.ProductSaleRequestDTO;
import com.inventory.model.Product;
import com.inventory.model.ProductSale;
import com.inventory.model.Supplier;

import java.util.Date;

public class ProductSaleUtils {

    public static ProductSale parseToProductSale(ProductSaleRequestDTO requestDTO,
                                                 Product product,
                                                 Supplier supplier) {
        return ProductSale.builder()
                .productId(product)
                .supplierId(supplier)
                .saleDate(new Date())
                .saleTime(new Date())
                .sellingPrice(requestDTO.getSellingPrice())
                .totalAmount(requestDTO.getSellingPrice() + 0)
                .status(StatusConstants.ACTIVE)
                .build();

    }
}
