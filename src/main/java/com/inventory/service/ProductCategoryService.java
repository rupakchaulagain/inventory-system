package com.inventory.service;

import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.productCategory.ProductCategoryRequestDTO;

import java.util.List;

public interface ProductCategoryService {

    void save(ProductCategoryRequestDTO requestDTO);

    List<DropDownResponseDTO> fetchActiveDropDownList();
}
