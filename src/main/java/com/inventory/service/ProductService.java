package com.inventory.service;

import com.inventory.dto.commons.DeleteRequestDTO;
import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.product.ProductRequestDTO;
import com.inventory.dto.request.product.ProductSearchRequestDTO;
import com.inventory.dto.request.product.ProductUpdateRequestDTO;
import com.inventory.dto.response.ProductMinimalResponseDTO;
import com.inventory.dto.response.ProductResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Rupak
 */
public interface ProductService {

    void save(ProductRequestDTO productRequestDTO);

    void update(ProductUpdateRequestDTO productUpdateRequestDTO);

    void delete(DeleteRequestDTO deleteRequestDTO);

    List<ProductMinimalResponseDTO> search(ProductSearchRequestDTO departmentSearchRequestDTO, Pageable pageable);

    ProductResponseDTO fetchDetails(Long id);

    List<DropDownResponseDTO> fetchProductForDropdown();
    
    List<DropDownResponseDTO> fetchActiveDropDownList();
}
