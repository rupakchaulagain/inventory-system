package com.inventory.service;

import com.inventory.dto.request.productSale.ProductSaleRequestDTO;
import com.inventory.dto.request.productSale.SaleSearchRequestDTO;
import com.inventory.dto.response.productSale.ProductSaleSearchResponseDTO;
import org.springframework.data.domain.Pageable;

public interface ProductSaleService {

    void save(ProductSaleRequestDTO requestDTO);

    ProductSaleSearchResponseDTO search(SaleSearchRequestDTO saleSearchRequestDTO, Pageable pageable);
}
