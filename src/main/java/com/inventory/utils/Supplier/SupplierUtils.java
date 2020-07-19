package com.inventory.utils.Supplier;

import com.inventory.constants.StatusConstants;
import com.inventory.dto.request.supplier.SupplierRequestDTO;
import com.inventory.model.Supplier;

import static com.inventory.constants.StatusConstants.ACTIVE;

/**
 * @author rupak ON 2020/07/14-10:20 PM
 */
public class SupplierUtils {

    public static Supplier parseToSupplier(SupplierRequestDTO supplierRequestDTO){

        Supplier supplier=new Supplier();
        supplier.setName(supplierRequestDTO.getSupplierName());
        supplier.setAddress(supplierRequestDTO.getSupplierAddress());
        supplier.setEmail(supplierRequestDTO.getSupplierEmail());
        supplier.setMobileNumber(supplierRequestDTO.getSupplierMobileNumber());
        supplier.setPanNumber(supplierRequestDTO.getSupplierPanNumber());
        supplier.setPhoneNumber(supplierRequestDTO.getSupplierPhoneNumber());
        supplier.setStatus(ACTIVE);

        return supplier;


    }
}
