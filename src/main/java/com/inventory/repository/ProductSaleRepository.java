package com.inventory.repository;

import com.inventory.model.ProductSale;
import com.inventory.repository.custom.ProductSaleRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSaleRepository extends JpaRepository<ProductSale, Long>, ProductSaleRepositoryCustom {
}
