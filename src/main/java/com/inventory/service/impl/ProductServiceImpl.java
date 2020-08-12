package com.inventory.service.impl;

import com.inventory.dto.commons.DeleteRequestDTO;
import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.product.ProductRequestDTO;
import com.inventory.dto.request.product.ProductSearchRequestDTO;
import com.inventory.dto.request.product.ProductUpdateRequestDTO;
import com.inventory.dto.response.product.ProductResponseDTO;
import com.inventory.dto.response.product.ProductSearchResponseDTO;
import com.inventory.exception.DataDuplicationException;
import com.inventory.exception.NoContentFoundException;
import com.inventory.model.Product;
import com.inventory.model.ProductCategory;
import com.inventory.model.ProductPrice;
import com.inventory.repository.ProductCategoryRepository;
import com.inventory.repository.ProductPriceRepository;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.SupplierRepository;
import com.inventory.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;

import static com.inventory.constants.ErrorMessageConstants.NAME_DUPLICATION_MESSAGE;
import static com.inventory.utils.Product.ProductUtils.parseToProduct;
import static com.inventory.utils.Product.ProductUtils.parseToProductPrice;

/**
 * @author Rupak
 */
@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductPriceRepository productPriceRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final SupplierRepository supplierRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductPriceRepository productPriceRepository,
                              ProductCategoryRepository productCategoryRepository,
                              SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.productPriceRepository = productPriceRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void save(ProductRequestDTO productRequestDTO) {

        Long count = productRepository.validateDuplicity(productRequestDTO);

        validateProductByCategoryAndType(count, productRequestDTO.getProductName());

        com.inventory.model.Supplier supplier = supplierRepository.findSupplierBySupplierId(productRequestDTO.getSupplierId());

        ProductCategory productCategory = productCategoryRepository.
                findProductCategoryById(productRequestDTO.getProductCategoryId())
                .orElseThrow(() -> PRODUCT_CATEGORY_NOT_FOUND.get());


        ProductPrice productPrice = parseToProductPrice(productRequestDTO);

        productPriceRepository.save(productPrice);

        Product product = parseToProduct(productRequestDTO,
                productPrice,
                productCategory);

        product.setSupplier(supplier);
        productRepository.save(product);

    }

    private void validateProductByCategoryAndType(Long count, String productName) {

        if (count.intValue() > 0)
            throw new DataDuplicationException(
                    String.format(NAME_DUPLICATION_MESSAGE, Product.class.getSimpleName(), productName));

    }

    @Override
    public void update(ProductUpdateRequestDTO productUpdateRequestDTO) {

    }

    @Override
    public void delete(DeleteRequestDTO deleteRequestDTO) {

        Product product = productRepository.findProductById(deleteRequestDTO.getId());
        product.setStatus(deleteRequestDTO.getStatus());
        product.setRemarks(deleteRequestDTO.getRemarks());
    }

    @Override
    public ProductSearchResponseDTO search(ProductSearchRequestDTO requestDTO, Pageable pageable) {

        ProductSearchResponseDTO responseDTOList = productRepository.search(requestDTO, pageable);

        return responseDTOList;
    }

    @Override
    public ProductResponseDTO fetchDetails(Long id) {

        ProductResponseDTO responseDTO = productRepository
                .fetchDetails(id);

        return responseDTO;

    }

    @Override
    public List<DropDownResponseDTO> fetchProductForDropdown() {

        List<DropDownResponseDTO> departmentDropDownDTOS = productRepository.fetchProductForDropdown()
                .orElseThrow(() -> PRODUCT_NOT_FOUND.get());

        return departmentDropDownDTOS;

    }

    @Override
    public List<DropDownResponseDTO> fetchActiveDropDownList() {
        return null;
    }

    private Supplier<NoContentFoundException> PRODUCT_NOT_FOUND = () ->
            new NoContentFoundException(Product.class);

    private Supplier<NoContentFoundException> PRODUCT_CATEGORY_NOT_FOUND = () ->
            new NoContentFoundException(ProductCategory.class);
}
