package com.inventory.constants;

/**
 * @author Rupak
 */
public class SwaggerConstants {

    //Base Class to fetch all APIs of Project...
    public static String BASE_PACKAGE = "com.inventory.controller";

    public static String PATH_REGEX = "/api.*";

    //A
    public static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v1/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };


    //P
    public interface ProductConstant {
        String BASE_API_VALUE = "This is Product Resource";
        String SAVE_OPERATION = "Save new product";
        String UPDATE_OPERATION = "Update existing product details";
        String DELETE_OPERATION = "Set product status as 'D' with specific remarks";
        String SEARCH_OPERATION = "Search product according to given request parameters";
        String DETAILS_OPERATION = "Fetch product details by its id";
        String FETCH_DETAILS_FOR_DROPDOWN = "Fetch minimal product details (id and name) for dropdown";
        String FETCH_PRODUCT_FOR_DROP_DOWN_OPERATION = "Fetch minimal product details (id and name) for dropdown";
        String FETCH_ACTIVE_PRODUCT_FOR_DROP_DOWN_OPERATION = "Fetch minimal active product details (id and name)";
    }
}
