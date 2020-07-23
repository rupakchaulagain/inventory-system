package com.inventory.controller;

import com.inventory.dto.request.productCategory.ProductCategoryRequestDTO;
import com.inventory.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import static com.inventory.constants.SwaggerConstants.ProductConstant.BASE_API_VALUE;
import static com.inventory.constants.SwaggerConstants.ProductConstant.FETCH_DETAILS_FOR_DROPDOWN;
import static com.inventory.constants.SwaggerConstants.ProductConstant.SAVE_OPERATION;
import static com.inventory.constants.WebResourceKeyConstants.ACTIVE;
import static com.inventory.constants.WebResourceKeyConstants.API_V1;
import static com.inventory.constants.WebResourceKeyConstants.MIN;
import static com.inventory.constants.WebResourceKeyConstants.ProductCategoryConstant.BASE_PRODUCT_CATEGORY;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

/**
 * @author rupak ON 2020/07/23-8:59 AM
 */
@RestController
@RequestMapping(value = API_V1 +BASE_PRODUCT_CATEGORY)
@Api(BASE_API_VALUE)
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }


    @PostMapping
    @ApiOperation(SAVE_OPERATION)
    public ResponseEntity<?> save(@Valid @RequestBody ProductCategoryRequestDTO requestDTO) {
        productCategoryService.save(requestDTO);
        return created(URI.create(API_V1 + BASE_PRODUCT_CATEGORY)).build();
    }

    @GetMapping(ACTIVE + MIN)
    @ApiOperation(FETCH_DETAILS_FOR_DROPDOWN)
    public ResponseEntity<?> fetchActiveDropDownList() {
        return ok(productCategoryService.fetchActiveDropDownList());
    }



}
