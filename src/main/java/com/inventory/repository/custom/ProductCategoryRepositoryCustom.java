package com.inventory.repository.custom;

import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.productCategory.ProductCategorySearchRequestDTO;
import com.inventory.dto.response.productCategory.ProductCategorySearchResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("productCategoryRepositoryCutom")
public interface ProductCategoryRepositoryCustom {

    Optional<List<DropDownResponseDTO>> fetchActiveDropDownList();

    ProductCategorySearchResponseDTO search(ProductCategorySearchRequestDTO searchRequestDTO, Pageable pageable);

    Optional<List<DropDownResponseDTO>> fetchSupplierWiseProductCategories(Long supplierId);
}
