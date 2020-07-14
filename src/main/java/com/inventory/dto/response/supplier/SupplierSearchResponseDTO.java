package com.inventory.dto.response.supplier;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author rupak ON 2020/07/14-11:22 PM
 */
@Getter
@Setter
public class SupplierSearchResponseDTO implements Serializable {

    private List<SupplierMinimalResponseDTO> responseDTOList;

    private int totalItems;
}
