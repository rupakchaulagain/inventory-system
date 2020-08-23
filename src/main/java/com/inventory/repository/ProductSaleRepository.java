package com.inventory.repository;

import com.inventory.model.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSaleRepository extends JpaRepository<ProductSale, Long> {
}
