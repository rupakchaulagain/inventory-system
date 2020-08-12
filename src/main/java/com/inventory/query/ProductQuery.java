package com.inventory.query;

import com.inventory.dto.request.product.ProductSearchRequestDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author Rupak
 */
public class ProductQuery {

    public static final String QUERY_TO_VALIDATE_DUPLICITY =
            " SELECT" +
                    " COUNT(p.id)" +
                    " FROM Product p" +
                    " LEFT JOIN ProductCategory pc ON p.productCategoryId.id=pc.id" +
                    " WHERE" +
                    " p.status!='D'" +
                    " AND pc.status!='D'" +
                    " AND p.productName=:productName" +
                    " AND p.productType=:productType" +
                    " AND pc.id=:productCategoryId";

    public final static String QUERY_TO_FETCH_DETAILS =
            "SELECT" +
                    " p.productName as productName," +              //[0]
                    " pc.name as productCategory," +
                    " p.productCode as productCode," +              //[1]
                    " price.costPrice as costPrice," +              //[2]
                    " price.sellingPrice as sellingPrice," +         //[3]
                    " p.productDescription as productDescription," + //[4]
                    " p.status as status"+
                    " FROM Product p" +
                    " LEFT JOIN ProductPrice price ON price.id =p.productPrice.id" +
                    " LEFT JOIN ProductCategory pc ON pc.id=p.productCategoryId.id" +
                    " WHERE p.id =:id" +
                    " AND p.status != 'D'" +
                    " AND price.status!='D'";

    public static final String QUERY_TO_FETCH_PRODUCT_FOR_DROPDOWN =
            "SELECT" +
                    " p.id as value," +
                    " p.productName as label" +
                    " FROM Product p" +
                    " WHERE p.status != 'D'" +
                    " ORDER BY p.id ASC";

    public static final String QUERY_TO_FETCH_ACTIVE_PRODUCT_FOR_DROPDOWN =
            "SELECT" +
                    " p.id as value," +
                    " p.name as label" +
                    " FROM Product p" +
                    " WHERE p.status = 'Y'" +
                    " ORDER BY p.id ASC";

    public static Function<ProductSearchRequestDTO, String> QUERY_TO_SEARCH_PRODUCT = (searchRequestDTO) -> {
        return " SELECT " +
                " p.id as id," +
                " p.productName as productName," +
                " pc.name as productCategory," +
                " p.productType as productType," +
                " p.productQuantity as productQuantity," +
                " pp.costPrice as costPrice," +
                " pp.sellingPrice as sellingPrice," +
                " p.status as status" +
                " FROM Product p" +
                " LEFT JOIN ProductCategory pc ON p.productCategoryId.id=pc.id" +
                " LEFT JOIN ProductPrice pp ON p.productPrice.id=pp.id" +
                GET_WHERE_CLAUSE_FOR_SEARCH_PRODUCT(searchRequestDTO);
    };


    private static String GET_WHERE_CLAUSE_FOR_SEARCH_PRODUCT(ProductSearchRequestDTO searchRequestDTO) {
        String whereClause = " WHERE" +
                " p.status!='D'"+
                " AND pc.status!='D'";

        if (!StringUtils.isEmpty(searchRequestDTO.getProductName()))
            whereClause += " AND p.productName='" + searchRequestDTO.getProductName() + "'";

        if (!Objects.isNull(searchRequestDTO.getProductCategoryId()))
            whereClause += " AND pc.id=" + searchRequestDTO.getProductCategoryId();

        if (!StringUtils.isEmpty(searchRequestDTO.getProductType()))
            whereClause += " AND p.productType='" + searchRequestDTO.getProductType() + "'";


        whereClause += " ORDER BY p.id DESC";

        return whereClause;
    }


}
