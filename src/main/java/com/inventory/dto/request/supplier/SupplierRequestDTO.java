package com.inventory.dto.request.supplier;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author rupak ON 2020/06/07-7:26 PM
 */

@Getter
public class SupplierRequestDTO implements Serializable {

    private String supplierName;

    private String supplierAddress;

    private String supplierPan;

    private String supplierPhoneNumber;

    private String supplierEmail;

    private String supplierMobileNumber;

    private String supplierWebsiteUrl;

    private Character status;

}
