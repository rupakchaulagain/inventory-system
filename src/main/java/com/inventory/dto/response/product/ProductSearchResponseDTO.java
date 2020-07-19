package com.inventory.dto.response.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author rupak ON 2020/07/19-12:14 PM
 */
@Getter
@Setter
public class ProductSearchResponseDTO implements Serializable {

    private List<ProductMinimalResponseDTO> responseDTOList;

    private int totalItems;
}
