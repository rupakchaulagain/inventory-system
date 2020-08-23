package com.inventory.query;

import com.inventory.dto.request.supplier.SupplierSearchRequestDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author rupak ON 2020/07/14-11:27 PM
 */
public class SupplierQuery {

    public static final String QUERY_TO_FETCH_SUPPLIER_FOR_DROPDOWN =
            "SELECT" +
                    " s.id as value," +
                    " s.name as label" +
                    " FROM Supplier s" +
                    " WHERE s.status != 'D'" +
                    " ORDER BY s.name ASC";

    public final static String QUERY_TO_FETCH_DETAILS =
            "SELECT" +
                    " s.name as supplierName," +
                    " s.panNumber as supplierPanNumber," +
                    " s.address as supplierAddress," +
                    " s.phoneNumber as supplierPhoneNumber," +
                    " s.websiteUrl as websiteUrl," +
                    " s.status as status"+
                    " FROM Supplier s" +
                    " WHERE s.id =:supplierId";


    public static Function<SupplierSearchRequestDTO, String> QUERY_TO_SEARCH_SUPPLIER = (searchRequestDTO) -> {
        return " SELECT" +
                " s.id as id,"+
                " s.name as supplierName," +
                " s.phoneNumber as supplierPhoneNumber," +
                " s.email  as supplierEmail,"+
                " s.panNumber as supplierPanNumber," +
                " s.address as supplierAddress," +
                " s.status as status"+
                " FROM Supplier s" +
                GET_WHERE_CLAUSE_FOR_SEARCH_SUPPLIER(searchRequestDTO);
    };


    private static String GET_WHERE_CLAUSE_FOR_SEARCH_SUPPLIER(SupplierSearchRequestDTO searchRequestDTO) {
        String whereClause = " WHERE" +
                " s.status!='D'";

        if (!StringUtils.isEmpty(searchRequestDTO.getSupplierName()))
            whereClause += " AND s.name='" + searchRequestDTO.getSupplierName()+"'";

        if (!StringUtils.isEmpty(searchRequestDTO.getSupplierPanNumber()))
            whereClause += " AND s.panNumber='" + searchRequestDTO.getSupplierPanNumber()+"'";

        whereClause+=" ORDER BY s.id DESC";

        return whereClause;
    }
}
