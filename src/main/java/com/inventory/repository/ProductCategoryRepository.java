package com.inventory.repository;

import com.inventory.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rupak ON 2020/07/23-8:21 PM
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
