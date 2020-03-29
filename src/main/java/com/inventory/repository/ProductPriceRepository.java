package com.inventory.repository;

import com.inventory.model.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rupak
 */
@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice,Long> {
}
