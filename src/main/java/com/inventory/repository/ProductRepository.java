package com.inventory.repository;

import com.inventory.model.Product;
import com.inventory.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

/**
 * @author Rupak
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> , ProductRepositoryCustom {

    @Query("SELECT p FROM Product p WHERE p.id=:id AND p.status='Y'")
    Product findProductById(@Param("id") Long id);
}
