package com.inventory.service.impl;

import com.inventory.dto.commons.DeleteRequestDTO;
import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.ProductRequestDTO;
import com.inventory.dto.request.ProductSearchRequestDTO;
import com.inventory.dto.request.ProductUpdateRequestDTO;
import com.inventory.dto.response.ProductMinimalResponseDTO;
import com.inventory.dto.response.ProductResponseDTO;
import com.inventory.model.Product;
import com.inventory.repository.ProductRepository;
import com.inventory.service.ProductService;
import com.inventory.utils.Product.ProductUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Rupak
 */
@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductRequestDTO productRequestDTO) {

        Product product= ProductUtils.parseToProduct(productRequestDTO);
        productRepository.save(product);

    }

    @Override
    public void update(ProductUpdateRequestDTO productUpdateRequestDTO) {

    }

    @Override
    public void delete(DeleteRequestDTO deleteRequestDTO) {

    }

    @Override
    public List<ProductMinimalResponseDTO> search(ProductSearchRequestDTO departmentSearchRequestDTO, Pageable pageable) {
        return null;
    }

    @Override
    public ProductResponseDTO fetchDetails(Long id) {
        return null;
    }

    @Override
    public List<DropDownResponseDTO> fetchDepartmentForDropdown() {
        return null;
    }
}
