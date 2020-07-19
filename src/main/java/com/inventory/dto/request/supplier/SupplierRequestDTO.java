package com.inventory.dto.request.supplier;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author rupak ON 2020/06/07-7:26 PM
 */

@Getter
public class SupplierRequestDTO implements Serializable {

    @NotNull
    @NotEmpty
    private String supplierName;

    @NotNull
    @NotEmpty
    private String supplierAddress;

    @NotNull
    @NotEmpty
    private String supplierPanNumber;

    private String supplierPhoneNumber;

    private String supplierMobileNumber;

    private String supplierEmail;

    private String supplierWebsiteUrl;

//    @NotNull
//    private Character status;

}
