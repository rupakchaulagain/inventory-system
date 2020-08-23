package com.inventory.repository.custom.impl;

import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.supplier.SupplierSearchRequestDTO;
import com.inventory.dto.response.product.ProductResponseDTO;
import com.inventory.dto.response.supplier.SupplierMinimalResponseDTO;
import com.inventory.dto.response.supplier.SupplierResponseDTO;
import com.inventory.dto.response.supplier.SupplierSearchResponseDTO;
import com.inventory.exception.NoContentFoundException;
import com.inventory.query.SupplierQuery;
import com.inventory.repository.custom.SupplierRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static com.inventory.constants.ErrorMessageConstants.NO_RECORD_FOUND;
import static com.inventory.constants.QueryConstants.SUPPLIER_ID;
import static com.inventory.logs.ProductConstant.PRODUCT;
import static com.inventory.logs.SupplierConstant.SUPPLIER;
import static com.inventory.query.SupplierQuery.QUERY_TO_SEARCH_SUPPLIER;
import static com.inventory.utils.commons.LogUtils.logError;
import static com.inventory.utils.commons.PageableUtils.addPagination;
import static com.inventory.utils.commons.QueryUtils.createQuery;
import static com.inventory.utils.commons.QueryUtils.transformQueryToResultList;
import static com.inventory.utils.commons.QueryUtils.transformQueryToSingleResult;

/**
 * @author rupak ON 2020/07/14-11:25 PM
 */
@Repository
@Transactional(readOnly = true)
public class SupplierRepositoryCustomImpl implements SupplierRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public SupplierSearchResponseDTO search(SupplierSearchRequestDTO requestDTO, Pageable pageable) {

        Query query = createQuery.apply(entityManager, QUERY_TO_SEARCH_SUPPLIER.apply(requestDTO));

        int totalItems = query.getResultList().size();

        addPagination.accept(pageable, query);

        List<SupplierMinimalResponseDTO> minimalResponseDTOS = transformQueryToResultList(query,
                SupplierMinimalResponseDTO.class);

        if (minimalResponseDTOS.isEmpty()) {
            SUPPLIER_NOT_FOUND.get();
        }

        SupplierSearchResponseDTO supplierSearchResponseDTO = new SupplierSearchResponseDTO();
        supplierSearchResponseDTO.setTotalItems(totalItems);
        supplierSearchResponseDTO.setResponseDTOList(minimalResponseDTOS);

        return supplierSearchResponseDTO;
    }

    @Override
    public Optional<List<DropDownResponseDTO>> fetchActiveDropDownList() {
        Query query = createQuery.apply(entityManager, SupplierQuery.QUERY_TO_FETCH_SUPPLIER_FOR_DROPDOWN);

        List<DropDownResponseDTO> dropDownDTOS = transformQueryToResultList(query, DropDownResponseDTO.class);

        return dropDownDTOS.isEmpty() ? Optional.empty() : Optional.of(dropDownDTOS);
    }

    @Override
    public SupplierResponseDTO fetchDetails(Long id) {

        Query query = createQuery.apply(entityManager, SupplierQuery.QUERY_TO_FETCH_DETAILS)
                .setParameter(SUPPLIER_ID, id);

        try {
            return transformQueryToSingleResult(query, SupplierResponseDTO.class);
        } catch (NoResultException e) {
            logError(SUPPLIER);
            throw new NoContentFoundException(com.inventory.model.Supplier.class, "id", id.toString());
        }
    }

    private Supplier<NoContentFoundException> SUPPLIER_NOT_FOUND = () -> {
        throw new NoContentFoundException(String.format(NO_RECORD_FOUND, "Supplier"));
    };
}
