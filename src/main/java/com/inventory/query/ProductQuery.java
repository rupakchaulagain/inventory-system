package com.inventory.query;

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

}
