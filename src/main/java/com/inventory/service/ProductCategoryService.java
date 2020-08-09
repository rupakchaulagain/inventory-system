package com.inventory.service;

import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.productCategory.ProductCategoryRequestDTO;
import com.inventory.dto.request.productCategory.ProductCategorySearchRequestDTO;
import com.inventory.dto.response.productCategory.ProductCategorySearchResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCategoryService {

    void save(ProductCategoryRequestDTO requestDTO);

    List<DropDownResponseDTO> fetchActiveDropDownList();

    ProductCategorySearchResponseDTO search(ProductCategorySearchRequestDTO searchRequestDTO, Pageable pageable);

    List<DropDownResponseDTO> fetchSupplierWiseProductCategories(Long supplierId);
}

