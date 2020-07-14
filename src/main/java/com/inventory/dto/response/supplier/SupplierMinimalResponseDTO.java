package com.inventory.dto.response.supplier;

import lombok.*;

import java.io.Serializable;

/**
 * @author rupak ON 2020/07/14-11:20 PM
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierMinimalResponseDTO implements Serializable {

    private Long id;

    private String supplierName;

    private String supplierPanNumber;

    private String supplierPhoneNumber;

    private String supplierAddress;

}
