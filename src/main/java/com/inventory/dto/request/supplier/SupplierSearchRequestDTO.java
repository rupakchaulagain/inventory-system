package com.inventory.dto.request.supplier;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author rupak ON 2020/07/14-11:18 PM
 */
@Getter
public class SupplierSearchRequestDTO implements Serializable {

    private String supplierName;

    private String supplierPanNumber;

}
