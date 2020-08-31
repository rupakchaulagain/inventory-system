package com.inventory.dto.request.productSale;

import lombok.Getter;

@Getter
public class ProductToSaleRequestDTO {

    private Long productId;

    private Long productQuantity;

    private Double discountAmount;

    private Double totalAmount;
}
