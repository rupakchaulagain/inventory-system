package com.inventory.service.impl;

import com.inventory.constants.StatusConstants;
import com.inventory.dto.request.productSale.ProductSaleRequestDTO;
import com.inventory.dto.request.productSale.ProductToSaleRequestDTO;
import com.inventory.model.Product;
import com.inventory.model.ProductSale;
import com.inventory.model.Sale;
import com.inventory.model.Supplier;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.ProductSaleRepository;
import com.inventory.repository.SaleRepository;
import com.inventory.repository.SupplierRepository;
import com.inventory.service.ProductSaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
@Slf4j
public class ProductSaleServiceImpl implements ProductSaleService {

    private final SaleRepository saleRepository;

    private final ProductSaleRepository productSaleRepository;

    private final SupplierRepository supplierRepository;

    private final ProductRepository productRepository;

    public ProductSaleServiceImpl(SaleRepository saleRepository, ProductSaleRepository productSaleRepository,
                                  SupplierRepository supplierRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productSaleRepository = productSaleRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void save(ProductSaleRequestDTO requestDTO) {

        List<ProductToSaleRequestDTO> productToSaleList = requestDTO.getProductList();

        List<ProductSale> productSaleList = new ArrayList<>();
        AtomicReference<Double> totalAmount = new AtomicReference<>(0D);


        Sale sale = Sale.builder()
                .saleDate(new Date())
                .saleTime(new Date())
                .totalAmount(requestDTO.getTotalAmount())
                .remarks("Sale")
                .status(StatusConstants.ACTIVE)
                .build();

        saleRepository.save(sale);

        productToSaleList.forEach(productToSale -> {

            Product product = productRepository.findProductById(productToSale.getProductId());

            ProductSale productSale = ProductSale.builder()
                    .supplierId( product.getSupplier())
                    .productId(product)
                    .discountAmount(productToSale.getDiscountAmount())
                    .sellingPrice(productToSale.getTotalAmount())
                    .saleId(sale)
                    .build();

            totalAmount.updateAndGet(v -> v + (productToSale.getTotalAmount()));

            productSaleList.add(productSale);


        });


        productSaleRepository.saveAll(productSaleList);


    }
}
