package com.inventory.dto.request.product;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Rupak
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDTO implements Serializable {

    @NotNull
    @NotEmpty
    private String productName;

    @NotNull
    @NotEmpty
    private String productType;

    @NotNull
    @NotEmpty
    private String productCategory;

    @NotNull
    @NotEmpty
    private String productCode;

    @NotNull
    @NotEmpty
    private String productQuantity;

    private String productDescription;

    @NotNull
    private Double costPrice;

    @NotNull
    private Double sellingPrice;

    private Double discountAmount;

    private Double discountPercentage;

    @NotNull
    private Long supplierId;

    @NotNull
    private Character status;


}
