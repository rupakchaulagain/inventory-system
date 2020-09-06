package com.inventory.repository.custom.impl;

import com.inventory.dto.request.productSale.SaleSearchRequestDTO;
import com.inventory.dto.response.productSale.ProductSaleSearchResponse;
import com.inventory.dto.response.productSale.ProductSaleSearchResponseDTO;
import com.inventory.exception.NoContentFoundException;
import com.inventory.query.ProductSaleQuery;
import com.inventory.repository.custom.ProductSaleRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Supplier;

import static com.inventory.constants.ErrorMessageConstants.NO_RECORD_FOUND;
import static com.inventory.utils.commons.PageableUtils.addPagination;
import static com.inventory.utils.commons.QueryUtils.createQuery;
import static com.inventory.utils.commons.QueryUtils.transformQueryToResultList;

@Repository
@Transactional(readOnly = true)
public class ProductSaleRepositoryCustomImpl implements ProductSaleRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductSaleSearchResponseDTO search(SaleSearchRequestDTO requestDTO, Pageable pageable) {
        Query query = createQuery.apply(entityManager, ProductSaleQuery.QUERY_TO_SEARCH_PRODUCT_SALE.apply(requestDTO));

        int totalItems = query.getResultList().size();

        addPagination.accept(pageable, query);

        List<ProductSaleSearchResponse> searchResponseList = transformQueryToResultList(query,
                ProductSaleSearchResponse.class);

        if (searchResponseList.isEmpty()) {
            PRODUCT_SALE_NOT_FOUND.get();
        }

        ProductSaleSearchResponseDTO searchResponseDTO = new ProductSaleSearchResponseDTO();
        searchResponseDTO.setTotalItems(totalItems);
        searchResponseDTO.setResponseDTOList(searchResponseList);

        return searchResponseDTO;
    }

    private Supplier<NoContentFoundException> PRODUCT_SALE_NOT_FOUND = () -> {
        throw new NoContentFoundException(String.format(NO_RECORD_FOUND, "Sales"));
    };
}
