package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<com.inventory.model.Supplier,Long> {

    @Query("SELECT s FROM Supplier s WHERE s.id=:id")
    com.inventory.model.Supplier findSupplierBySupplierId(@Param("id") Long supplierId);
}
