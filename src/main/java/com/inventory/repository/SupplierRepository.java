package com.inventory.repository;

import com.inventory.dto.request.supplier.SupplierSearchRequestDTO;
import com.inventory.dto.response.supplier.SupplierSearchResponseDTO;
import com.inventory.repository.custom.SupplierRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<com.inventory.model.Supplier,Long>,
        SupplierRepositoryCustom {

    @Query("SELECT s FROM Supplier s WHERE s.id=:id")
    com.inventory.model.Supplier findSupplierBySupplierId(@Param("id") Long supplierId);

}
