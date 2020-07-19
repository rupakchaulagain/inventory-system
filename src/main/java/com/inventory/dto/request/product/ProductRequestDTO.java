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
    private Long supplierId;

    @NotNull
    @NotEmpty
    private String productCategory;

    @NotNull
    @NotEmpty
    private String productType;

    @NotNull
    @NotEmpty
    private String productName;

    private String productDescription;

    @NotNull
    @NotEmpty
    private String productQuantity;

    @NotNull
    private String productCostPrice;

    @NotNull
    private String productSellingPrice;

    private String productDiscountAmount;

    private String productDiscountPercentage;
//
//    @NotNull
//    private Character status;


}
