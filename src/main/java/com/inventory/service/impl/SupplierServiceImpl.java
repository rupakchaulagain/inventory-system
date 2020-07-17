package com.inventory.service.impl;

import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.supplier.SupplierRequestDTO;
import com.inventory.dto.request.supplier.SupplierSearchRequestDTO;
import com.inventory.dto.response.supplier.SupplierSearchResponseDTO;
import com.inventory.exception.NoContentFoundException;
import com.inventory.model.Product;
import com.inventory.model.Supplier;
import com.inventory.repository.SupplierRepository;
import com.inventory.service.SupplierService;
import com.inventory.utils.Supplier.SupplierUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rupak ON 2020/06/07-7:31 PM
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void save(SupplierRequestDTO requestDTO) {

        validateSupplierByNameAndPanNumber(requestDTO.getSupplierName(),
                requestDTO.getSupplierPan());
        Supplier supplier = SupplierUtils.parseToSupplier(requestDTO);
        supplierRepository.save(supplier);


    }

    @Override
    public SupplierSearchResponseDTO search(SupplierSearchRequestDTO supplierSearchRequestDTO, Pageable pageable) {

        SupplierSearchResponseDTO supplierSearchResponseDTO = supplierRepository.search(supplierSearchRequestDTO,
                pageable);

        return supplierSearchResponseDTO;
    }

    @Override
    public List<DropDownResponseDTO> fetchActiveDropDownList() {

        List<DropDownResponseDTO> departmentDropDownDTOS = supplierRepository.fetchActiveDropDownList()
                .orElseThrow(() -> SUPPLIER_NOT_FOUND.get());

        return departmentDropDownDTOS;
    }

    private void validateSupplierByNameAndPanNumber(String supplierName,
                                                    String supplierPan) {
    }

    private java.util.function.Supplier<NoContentFoundException> SUPPLIER_NOT_FOUND = () ->
            new NoContentFoundException(Supplier.class);
}
