package com.inventory.service.impl;

import com.inventory.dto.request.productSale.ProductSaleRequestDTO;
import com.inventory.model.Product;
import com.inventory.model.ProductSale;
import com.inventory.model.Supplier;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.ProductSaleRepository;
import com.inventory.repository.SupplierRepository;
import com.inventory.service.ProductSaleService;
import com.inventory.utils.ProductSaleUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class ProductSaleServiceImpl implements ProductSaleService {

    private final ProductSaleRepository productSaleRepository;

    private final SupplierRepository supplierRepository;

    private final ProductRepository productRepository;

    public ProductSaleServiceImpl(ProductSaleRepository productSaleRepository,
                                  SupplierRepository supplierRepository, ProductRepository productRepository) {
        this.productSaleRepository = productSaleRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void save(ProductSaleRequestDTO requestDTO) {


        Supplier supplier = supplierRepository.findSupplierBySupplierId(requestDTO.getSupplierId());

        Product product = productRepository.findProductById(requestDTO.getProductId());

        ProductSale productSale = ProductSaleUtils.parseToProductSale(requestDTO, product, supplier);

        productSaleRepository.save(productSale);


    }
}
