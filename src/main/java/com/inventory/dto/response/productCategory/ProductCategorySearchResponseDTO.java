package com.inventory.dto.response.productCategory;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author rupak ON 2020/08/08-10:56 PM
 */
@Getter
@Setter
public class ProductCategorySearchResponseDTO {

    private List<ProductCategoryMinimalResponseDTO> responseDTOList;

    private int totalItems;
}
