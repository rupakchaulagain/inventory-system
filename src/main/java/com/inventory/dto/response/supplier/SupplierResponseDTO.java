package com.inventory.dto.response.supplier;

import lombok.*;

import java.io.Serializable;

/**
 * @author rupak ON 2020/08/15-4:50 PM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierResponseDTO implements Serializable {

    private String supplierName;

    private String supplierAddress;

    private String supplierPanNumber;

    private String supplierPhoneNumber;

    private String websiteUrl;

    private Character status;


}