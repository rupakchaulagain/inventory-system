package com.inventory.dto.response.product;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rupak
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO implements Serializable {

    private Long id;

    private String productName;

    private String productCategory;

    private String productType;

    private String productCode;

    private Double costPrice;

    private Double sellingPrice;

    private Double discountAmount;

    private String productDescription;

    private Character status;


}
