package com.inventory.query;

import com.inventory.dto.request.productSale.SaleSearchRequestDTO;

import java.util.function.Function;

public class ProductSaleQuery {
    public static Function<SaleSearchRequestDTO, String> QUERY_TO_SEARCH_PRODUCT_SALE = (searchRequestDTO) -> {
        return " SELECT" +
                " s.id as saleId," +
                " s.saleDate as saleDate," +
                " s.saleTime as saleTime," +
                " s.totalQuantity  as totalQuantity," +
                " s.totalAmount  as totalAmount," +
                " s.status as status" +
                " FROM Sale s" +
                GET_WHERE_CLAUSE_FOR_SEARCH_PRODUCT_SALE(searchRequestDTO);
    };

    private static String GET_WHERE_CLAUSE_FOR_SEARCH_PRODUCT_SALE(SaleSearchRequestDTO searchRequestDTO) {

        String whereClause = " WHERE" +
                " s.status!='D'";

//        if (!StringUtils.isEmpty(searchRequestDTO.getFromDate()))
//            whereClause += " AND s.saleDate='" + searchRequestDTO.getFromDate() + "'";
//

        whereClause += " ORDER BY s.id DESC";

        return whereClause;
    }
}
