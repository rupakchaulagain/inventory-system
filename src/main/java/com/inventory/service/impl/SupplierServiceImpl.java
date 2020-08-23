package com.inventory.service.impl;

import com.inventory.dto.commons.DeleteRequestDTO;
import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.supplier.SupplierRequestDTO;
import com.inventory.dto.request.supplier.SupplierSearchRequestDTO;
import com.inventory.dto.response.supplier.SupplierResponseDTO;
import com.inventory.dto.response.supplier.SupplierSearchResponseDTO;
import com.inventory.exception.DataDuplicationException;
import com.inventory.exception.NoContentFoundException;
import com.inventory.model.Product;
import com.inventory.model.Supplier;
import com.inventory.repository.SupplierRepository;
import com.inventory.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.inventory.constants.ErrorMessageConstants.NAME_DUPLICATION_MESSAGE;
import static com.inventory.utils.SupplierUtils.parseToSupplier;

/**
 * @author rupak ON 2020/06/07-7:31 PM
 */
@Service
@Transactional
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void save(SupplierRequestDTO requestDTO) {

        validateSupplierByNameAndPanNumber(requestDTO.getSupplierName(),
                requestDTO.getSupplierPanNumber());
        Supplier supplier = parseToSupplier(requestDTO);
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

    @Override
    public void delete(DeleteRequestDTO deleteRequestDTO) {
        Supplier supplier = supplierRepository.findSupplierBySupplierId(deleteRequestDTO.getId());
        supplier.setStatus(deleteRequestDTO.getStatus());
        supplier.setRemarks(deleteRequestDTO.getRemarks());

    }

    @Override
    public SupplierResponseDTO fetchDetails(Long id) {
        SupplierResponseDTO responseDTO=supplierRepository.fetchDetails(id);

        return responseDTO;
    }

    private void validateSupplierByNameAndPanNumber(String supplierName,
                                                    String supplierPan) {

        Long count= supplierRepository.validateDuplicityBySupplierNameAndPan(supplierName,supplierPan);

        if (count.intValue() > 0)
            throw new DataDuplicationException(
                    String.format(NAME_DUPLICATION_MESSAGE, Product.class.getSimpleName(), supplierName));

    }

    private java.util.function.Supplier<NoContentFoundException> SUPPLIER_NOT_FOUND = () ->
            new NoContentFoundException(Supplier.class);
}
