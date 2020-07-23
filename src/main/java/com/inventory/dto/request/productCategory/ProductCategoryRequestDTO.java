package com.inventory.dto.request.productCategory;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author rupak ON 2020/07/23-7:36 PM
 */
@Getter
public class ProductCategoryRequestDTO implements Serializable {

    @NotNull
    private Long supplierId;

    @NotNull
    @NotEmpty
    private String productCategoryName;

    private String productCategoryDescription;

    private Character status;

}
