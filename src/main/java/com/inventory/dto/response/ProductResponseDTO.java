package com.inventory.dto.response;

import lombok.*;

/**
 * @author Rupak
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDTO {

    private String productName;
    private String productCode;
    private Double costPrice;
    private Double sellingPrice;
    private String productDescription;

}
