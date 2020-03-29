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
public class ProductPriceRequestDTO implements Serializable {

    private Double costPrice;

    private Double sellingPrice;

    private Double discountAmount;

    private Double discountPercentage;

    private Character status;
}
