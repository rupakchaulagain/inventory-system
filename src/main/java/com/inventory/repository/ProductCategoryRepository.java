package com.inventory.repository;

import com.inventory.model.ProductCategory;
import com.inventory.repository.custom.ProductCategoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author rupak ON 2020/07/23-8:21 PM
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>, ProductCategoryRepositoryCustom {

    @Query("SELECT pc from ProductCategory pc WHERE pc.id=:id AND pc.status='Y'")
    Optional<ProductCategory> findProductCategoryById(@Param("id") Long id);
}
