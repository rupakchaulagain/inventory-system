package com.inventory.service;

import com.inventory.dto.commons.DeleteRequestDTO;
import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.supplier.SupplierRequestDTO;
import com.inventory.dto.request.supplier.SupplierSearchRequestDTO;
import com.inventory.dto.response.supplier.SupplierMinimalResponseDTO;
import com.inventory.dto.response.supplier.SupplierSearchResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SupplierService {

    void save(SupplierRequestDTO requestDTO);

    SupplierSearchResponseDTO search(SupplierSearchRequestDTO supplierSearchRequestDTO, Pageable pageable);

    List<DropDownResponseDTO> fetchActiveDropDownList();

    void delete(DeleteRequestDTO deleteRequestDTO);
}
