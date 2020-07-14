package com.inventory.repository.custom;

import com.inventory.dto.request.supplier.SupplierSearchRequestDTO;
import com.inventory.dto.response.supplier.SupplierSearchResponseDTO;
import org.springframework.data.domain.Pageable;

public interface SupplierRepositoryCustom {

    SupplierSearchResponseDTO search(SupplierSearchRequestDTO supplierSearchRequestDTO, Pageable pageable);
}
