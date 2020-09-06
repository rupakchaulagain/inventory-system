package com.inventory.dto.response.productSale;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaleSearchResponse {

    private Long saleId;

    private Date saleDate;

    private Date saleTime;

    private Double totalAmount;

    private Long totalQuantity;

    private Character status;
}
