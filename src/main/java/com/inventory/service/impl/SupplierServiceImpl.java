package com.inventory.service.impl;

import com.inventory.dto.request.supplier.SupplierRequestDTO;
import com.inventory.dto.request.supplier.SupplierSearchRequestDTO;
import com.inventory.dto.response.supplier.SupplierSearchResponseDTO;
import com.inventory.model.Supplier;
import com.inventory.repository.SupplierRepository;
import com.inventory.service.SupplierService;
import com.inventory.utils.Supplier.SupplierUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    private void validateSupplierByNameAndPanNumber(String supplierName,
                                                    String supplierPan) {
    }
}
