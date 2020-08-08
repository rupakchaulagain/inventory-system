package com.inventory.query;

import com.inventory.dto.request.productCategory.ProductCategorySearchRequestDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author rupak ON 2020/08/08-10:49 PM
 */
public class ProductCategoryQuery {

    public static final String QUERY_TO_FETCH_PRODUCT_CATEGORY_FOR_DROPDOWN =
            "SELECT" +
                    " s.id as value," +
                    " s.name as label" +
                    " FROM Supplier s" +
                    " WHERE s.status != 'D'" +
                    " ORDER BY s.name ASC";

    public static final Function<ProductCategorySearchRequestDTO, String> QUERY_TO_SEARCH_PRODUCT_CATEGORY = (searchRequestDTO) -> {
        return " SELECT" +
                " pc.id as id," +
                " s.name as supplierName," +
                " pc.name as productCategoryName," +
                " pc.status as status" +
                " FROM ProductCategory pc" +
                " LEFT JOIN Supplier s ON s.id=pc.supplierId.id" +
                GET_WHERE_CLAUSE_FOR_SEARCH_PRODUCT_CATEGORY(searchRequestDTO);
    };


    private static String GET_WHERE_CLAUSE_FOR_SEARCH_PRODUCT_CATEGORY(ProductCategorySearchRequestDTO searchRequestDTO) {
        String whereClause = " WHERE" +
                " pc.status!='D'";

        if (!StringUtils.isEmpty(searchRequestDTO.getProductCategoryName()))
            whereClause += " AND pc.name='" + searchRequestDTO.getProductCategoryName() + "'";

        if (!Objects.isNull(searchRequestDTO.getSupplierId()))
            whereClause += " AND s.id=" + searchRequestDTO.getSupplierId();

        whereClause += " ORDER BY pc.id DESC";

        return whereClause;
    }
}
