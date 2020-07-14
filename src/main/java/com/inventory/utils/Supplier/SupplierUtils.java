package com.inventory.utils.Supplier;

import com.inventory.dto.request.supplier.SupplierRequestDTO;
import com.inventory.model.Supplier;

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
        supplier.setPanNumber(supplierRequestDTO.getSupplierPan());
        supplier.setPhoneNumber(supplierRequestDTO.getSupplierPhoneNumber());
        supplier.setStatus(supplierRequestDTO.getStatus());

        return supplier;


    }
}
