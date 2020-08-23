package com.inventory.service;

import com.inventory.dto.request.productSale.ProductSaleRequestDTO;

public interface ProductSaleService {

    void save(ProductSaleRequestDTO requestDTO);
}
