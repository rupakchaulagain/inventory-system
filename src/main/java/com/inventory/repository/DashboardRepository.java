package com.inventory.repository;

import com.inventory.model.Product;
import com.inventory.repository.custom.DashboardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DashboardRepository extends JpaRepository<Product,Long>, DashboardRepositoryCustom {

    @Query("Select COUNT(p.id) FROM Product p WHERE p.status='Y'")
    Optional<Long> findNumberOfActiveProducts();

    @Query("Select COUNT(s.id) FROM Supplier s WHERE s.status='Y'")
    Optional<Long> findNumberOfActiveSupplier();

    @Query("Select SUM(s.totalAmount) FROM Sale s WHERE s.status='Y'")
    Optional<Double> findTotalRevenueGenerated();
}
