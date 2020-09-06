package com.inventory.dto.response.productSale;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaleSearchResponseDTO {

    private List<ProductSaleSearchResponse> responseDTOList;

    private int totalItems;
}
