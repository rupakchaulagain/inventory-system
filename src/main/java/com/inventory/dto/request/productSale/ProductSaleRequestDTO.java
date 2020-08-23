package com.inventory.dto.request.productSale;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ProductSaleRequestDTO implements Serializable{

    private Long supplierId;

    private Long productId;

    private Double sellingPrice;

}
