package com.inventory.repository;

import com.inventory.model.Product;
import com.inventory.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rupak
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> , ProductRepositoryCustom {
}
