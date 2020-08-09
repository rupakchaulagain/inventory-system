package com.inventory.service.impl;

import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.productCategory.ProductCategoryRequestDTO;
import com.inventory.dto.request.productCategory.ProductCategorySearchRequestDTO;
import com.inventory.dto.response.productCategory.ProductCategorySearchResponseDTO;
import com.inventory.exception.NoContentFoundException;
import com.inventory.model.ProductCategory;
import com.inventory.model.Supplier;
import com.inventory.repository.ProductCategoryRepository;
import com.inventory.repository.SupplierRepository;
import com.inventory.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.inventory.utils.ProductCategory.ProductCategoryUtils.parseToProductCategory;

/**
 * @author rupak ON 2020/07/23-8:20 PM
 */
@Service
@Transactional
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final SupplierRepository supplierRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServiceImpl(SupplierRepository supplierRepository,
                                      ProductCategoryRepository productCategoryRepository) {
        this.supplierRepository = supplierRepository;
        this.productCategoryRepository = productCategoryRepository;
    }


    @Override
    public void save(ProductCategoryRequestDTO requestDTO) {

        
        validateProductCategoryDuplicity(requestDTO);
        
        Supplier supplier = supplierRepository.findSupplierBySupplierId(requestDTO.getSupplierId());
        
        productCategoryRepository.save(parseToProductCategory(requestDTO, supplier));

    }

    @Override
    public List<DropDownResponseDTO> fetchActiveDropDownList() {

        List<DropDownResponseDTO> downResponseDTOS = productCategoryRepository.fetchActiveDropDownList()
                .orElseThrow(() -> PRODUCT_CATEGORY_NOT_FOUND.get());

        return downResponseDTOS;


    }

    @Override
    public ProductCategorySearchResponseDTO search(ProductCategorySearchRequestDTO searchRequestDTO, Pageable pageable) {
        ProductCategorySearchResponseDTO searchResponseDTO = productCategoryRepository.search(searchRequestDTO,
                pageable);

        return searchResponseDTO;
    }

    @Override
    public List<DropDownResponseDTO> fetchSupplierWiseProductCategories(Long supplierId) {
        List<DropDownResponseDTO> downResponseDTOS = productCategoryRepository.fetchSupplierWiseProductCategories(supplierId)
                .orElseThrow(() -> PRODUCT_CATEGORY_NOT_FOUND.get());

        return downResponseDTOS;
    }

    private void validateProductCategoryDuplicity(ProductCategoryRequestDTO requestDTO) {

    }

    private java.util.function.Supplier<NoContentFoundException> PRODUCT_CATEGORY_NOT_FOUND = () ->
            new NoContentFoundException(ProductCategory.class);
}
