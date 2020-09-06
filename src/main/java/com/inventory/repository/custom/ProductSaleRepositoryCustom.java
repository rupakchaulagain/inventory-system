package com.inventory.repository.custom;

import com.inventory.dto.request.productSale.SaleSearchRequestDTO;
import com.inventory.dto.response.productSale.ProductSaleSearchResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("productSaleRepositoryCustom")
public interface ProductSaleRepositoryCustom {

    ProductSaleSearchResponseDTO search(SaleSearchRequestDTO requestDTO, Pageable pageable);
}
