package com.inventory.repository.custom;

import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.product.ProductRequestDTO;
import com.inventory.dto.request.product.ProductSearchRequestDTO;
import com.inventory.dto.response.product.ProductResponseDTO;
import com.inventory.dto.response.product.ProductSearchResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Rupak
 */
@Repository
@Qualifier("productRepositoryCustom")
public interface ProductRepositoryCustom {

    Long validateDuplicity(ProductRequestDTO requestDTO);

    Optional<List<DropDownResponseDTO>> fetchProductForDropdown();

    ProductResponseDTO fetchDetails(Long id);

    ProductSearchResponseDTO search(ProductSearchRequestDTO requestDTO, Pageable pageable);
}
