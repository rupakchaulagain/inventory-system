package com.inventory.dto.response.productCategory;

import lombok.*;

import java.io.Serializable;

/**
 * @author rupak ON 2020/08/08-10:57 PM
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryMinimalResponseDTO implements Serializable{

    private Long id;

    private String supplierName;

    private String productCategoryName;

    private Character status;

}
