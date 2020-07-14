package com.inventory.query;

import com.inventory.dto.request.supplier.SupplierSearchRequestDTO;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author rupak ON 2020/07/14-11:27 PM
 */
public class SupplierQuery {

    public static Function<SupplierSearchRequestDTO, String> QUERY_TO_SEARCH_SUPPLIER = (searchRequestDTO) -> {
        return " SELECT" +
                " s.name as supplierName," +
                " s.phonenNumber as supplierPhoneNumber," +
                " s.panNumber as supplierPanNumber" +
                " FROM Supplier s" +
                GET_WHERE_CLAUSE_FOR_SEARCH_SUPPLIER(searchRequestDTO);
    };


    private static String GET_WHERE_CLAUSE_FOR_SEARCH_SUPPLIER(SupplierSearchRequestDTO searchRequestDTO) {
        String whereClause = " WHERE" +
                " s.status!='D'";

        if (!Objects.isNull(searchRequestDTO.getSupplierName()))
            whereClause += " AND s.name= " + searchRequestDTO.getSupplierName();

        return whereClause;
    }

    ;
}
