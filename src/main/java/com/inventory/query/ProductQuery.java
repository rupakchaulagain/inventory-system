package com.inventory.query;

import com.inventory.dto.request.product.ProductSearchRequestDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

/**
 * @author Rupak
 */
public class ProductQuery {

    public static final String QUERY_TO_VALIDATE_DUPLICITY =
            " SELECT" +
                    " COUNT(p.id)" +
                    " FROM Product p" +
                    " WHERE" +
                    " p.status!='D'" +
                    " AND p.productName=:productName" +
                    " AND p.productType=:productType" +
                    " AND p.productCategory=:productCategory";

    public final static String QUERY_TO_FETCH_DETAILS =
            "SELECT" +
                    " p.productName as productName," +              //[0]
                    " p.productCode as productCode," +              //[1]
                    " price.costPrice as costPrice," +              //[2]
                    " price.sellingPrice as sellingPrice," +         //[3]
                    " p.productDescription as productDescription" + //[4]
                    " FROM Product p" +
                    " LEFT JOIN ProductPrice price ON price.id =p.productPrice.id" +
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
                " p.productName as productName," +
                " p.productCategory as productCategory," +
                " p.productType as productType," +
                " p.productQuantity as productQuantity," +
                " pp.costPrice as costPrice," +
                " pp.sellingPrice as sellingPrice" +
                " FROM Product p" +
                " LEFT JOIN ProductPrice pp ON p.productPrice.id=pp.id"+
                GET_WHERE_CLAUSE_FOR_SEARCH_PRODUCT(searchRequestDTO);
    };


    private static String GET_WHERE_CLAUSE_FOR_SEARCH_PRODUCT(ProductSearchRequestDTO searchRequestDTO) {
        String whereClause = " WHERE" +
                " p.status!='D'";

        if (!StringUtils.isEmpty(searchRequestDTO.getProductName()))
            whereClause += " AND p.productName='" + searchRequestDTO.getProductName()+"'";

        if (!StringUtils.isEmpty(searchRequestDTO.getProductCategory()))
            whereClause += " AND p.productCategory='" + searchRequestDTO.getProductCategory()+"'";;

        if (!StringUtils.isEmpty(searchRequestDTO.getProductType()))
            whereClause += " AND p.productType='" + searchRequestDTO.getProductType()+"'";;

//        if (!StringUtils.isEmpty(searchRequestDTO.getProductCode()))
//            whereClause += " AND s.panNumber='" + searchRequestDTO.getProductCode()+"'";;

        return whereClause;
    }



}
