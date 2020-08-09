package com.inventory.repository.custom.impl;

import com.inventory.dto.commons.DropDownResponseDTO;
import com.inventory.dto.request.productCategory.ProductCategorySearchRequestDTO;
import com.inventory.dto.response.productCategory.ProductCategoryMinimalResponseDTO;
import com.inventory.dto.response.productCategory.ProductCategorySearchResponseDTO;
import com.inventory.exception.NoContentFoundException;
import com.inventory.query.ProductCategoryQuery;
import com.inventory.repository.custom.ProductCategoryRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static com.inventory.constants.ErrorMessageConstants.NO_RECORD_FOUND;
import static com.inventory.constants.QueryConstants.SUPPLIER_ID;
import static com.inventory.utils.commons.PageableUtils.addPagination;
import static com.inventory.utils.commons.QueryUtils.createQuery;
import static com.inventory.utils.commons.QueryUtils.transformQueryToResultList;

/**
 * @author rupak ON 2020/08/08-10:46 PM
 */
@Repository
@Transactional(readOnly = true)
public class ProductCategoryRepositoryCustomImpl implements ProductCategoryRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<List<DropDownResponseDTO>> fetchActiveDropDownList() {

        Query query = createQuery.apply(entityManager, ProductCategoryQuery.QUERY_TO_FETCH_PRODUCT_CATEGORY_FOR_DROPDOWN);

        List<DropDownResponseDTO> dropDownDTOS = transformQueryToResultList(query, DropDownResponseDTO.class);

        return dropDownDTOS.isEmpty() ? Optional.empty() : Optional.of(dropDownDTOS);
    }

    @Override
    public ProductCategorySearchResponseDTO search(ProductCategorySearchRequestDTO searchRequestDTO, Pageable pageable) {

        Query query = createQuery.apply(entityManager, ProductCategoryQuery.QUERY_TO_SEARCH_PRODUCT_CATEGORY.apply(searchRequestDTO));

        int totalItems = query.getResultList().size();

        addPagination.accept(pageable, query);

        List<ProductCategoryMinimalResponseDTO> minimalResponseDTOS = transformQueryToResultList(query,
                ProductCategoryMinimalResponseDTO.class);

        if (minimalResponseDTOS.isEmpty()) {
            PRRODUCT_CATEGORY_NOT_FOUND.get();
        }

        ProductCategorySearchResponseDTO searchResponseDTO = new ProductCategorySearchResponseDTO();
        searchResponseDTO.setTotalItems(totalItems);
        searchResponseDTO.setResponseDTOList(minimalResponseDTOS);

        return searchResponseDTO;
    }

    @Override
    public Optional<List<DropDownResponseDTO>> fetchSupplierWiseProductCategories(Long supplierId) {
        Query query = createQuery.apply(entityManager, ProductCategoryQuery.QUERY_TO_FETCH_SUPPLIER_WISE_PRODUCT_CATEGORIES)
                .setParameter(SUPPLIER_ID,supplierId);

        List<DropDownResponseDTO> dropDownDTOS = transformQueryToResultList(query, DropDownResponseDTO.class);

        return dropDownDTOS.isEmpty() ? Optional.empty() : Optional.of(dropDownDTOS);
    }

    private Supplier<NoContentFoundException> PRRODUCT_CATEGORY_NOT_FOUND = () -> {
        throw new NoContentFoundException(String.format(NO_RECORD_FOUND, "ProductCategory"));
    };
}
