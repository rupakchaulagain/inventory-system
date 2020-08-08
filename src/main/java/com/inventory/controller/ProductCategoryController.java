package com.inventory.controller;

import com.inventory.dto.request.productCategory.ProductCategoryRequestDTO;
import com.inventory.dto.request.productCategory.ProductCategorySearchRequestDTO;
import com.inventory.dto.request.supplier.SupplierSearchRequestDTO;
import com.inventory.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import static com.inventory.constants.SwaggerConstants.ProductConstant.*;
import static com.inventory.constants.WebResourceKeyConstants.*;
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

    @PutMapping(SEARCH)
    @ApiOperation(SEARCH_OPERATION)
    public ResponseEntity<?> search(@RequestBody ProductCategorySearchRequestDTO searchRequestDTO,
                                    @RequestParam("page") int page,
                                    @RequestParam("size") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ok(productCategoryService.search(searchRequestDTO, pageable));
    }

    @GetMapping(ACTIVE + MIN)
    @ApiOperation(FETCH_DETAILS_FOR_DROPDOWN)
    public ResponseEntity<?> fetchActiveDropDownList() {
        return ok(productCategoryService.fetchActiveDropDownList());
    }



}
