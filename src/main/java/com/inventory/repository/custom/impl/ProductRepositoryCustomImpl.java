package com.inventory.repository.custom.impl;

import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.product.ProductRequestDTO;
import com.inventory.dto.response.ProductResponseDTO;
import com.inventory.exception.NoContentFoundException;
import com.inventory.model.Product;
import com.inventory.repository.custom.ProductRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;
import java.util.Optional;

import static com.inventory.constants.QueryConstants.*;
import static com.inventory.logs.ProductConstant.PRODUCT;
import static com.inventory.query.ProductQuery.*;
import static com.inventory.utils.commons.LogUtils.logError;
import static com.inventory.utils.commons.QueryUtils.*;

/**
 * @author Rupak
 */
@Repository
@Transactional(readOnly = true)
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long validateDuplicity(ProductRequestDTO requestDTO) {
        Query query = createQuery.apply(entityManager, QUERY_TO_VALIDATE_DUPLICITY)
                .setParameter(PRODUCT_NAME, requestDTO.getProductName())
                .setParameter(PRODUCT_TYPE, requestDTO.getProductType())
                .setParameter(PRODUCT_CATEGORY, requestDTO.getProductCategory());

        return (Long) query.getSingleResult();
    }

    @Override
    public Optional<List<DropDownResponseDTO>> fetchProductForDropdown() {
        Query query = createQuery.apply(entityManager, QUERY_TO_FETCH_PRODUCT_FOR_DROPDOWN);

        List<DropDownResponseDTO> dropDownDTOS = transformQueryToResultList(query, DropDownResponseDTO.class);

        return dropDownDTOS.isEmpty() ? Optional.empty() : Optional.of(dropDownDTOS);
    }

    @Override
    public ProductResponseDTO fetchDetails(Long id) {

        Query query = createQuery.apply(entityManager, QUERY_TO_FETCH_DETAILS)
                .setParameter(ID, id);

        try {
            return transformQueryToSingleResult(query, ProductResponseDTO.class);
        } catch (NoResultException e) {
            logError(PRODUCT);
            throw new NoContentFoundException(Product.class, "id", id.toString());
        }
    }
}
