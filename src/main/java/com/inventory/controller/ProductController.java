package com.inventory.controller;

import com.inventory.dto.commons.DeleteRequestDTO;
import com.inventory.dto.request.product.ProductRequestDTO;
import com.inventory.dto.request.product.ProductSearchRequestDTO;
import com.inventory.dto.request.product.ProductUpdateRequestDTO;
import com.inventory.service.ProductService;
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
import static com.inventory.constants.WebResourceKeyConstants.ProductConstant.BASE_PRODUCT;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

/**
 * @author Rupak
 */
@RestController
@RequestMapping(value = API_V1 +BASE_PRODUCT)
@Api(BASE_API_VALUE)
public class ProductController {

    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ApiOperation(SAVE_OPERATION)
    public ResponseEntity<?> save(@Valid @RequestBody ProductRequestDTO requestDTO) {
        productService.save(requestDTO);
        return created(URI.create(API_V1 + BASE_PRODUCT)).build();
    }


    @PutMapping
    @ApiOperation(UPDATE_OPERATION)
    public ResponseEntity<?> update(@Valid @RequestBody ProductUpdateRequestDTO productUpdateRequestDTO) {
        productService.update(productUpdateRequestDTO);
        return ok().build();
    }

    @DeleteMapping
    @ApiOperation(DELETE_OPERATION)
    public ResponseEntity<?> delete( @RequestBody DeleteRequestDTO deleteRequestDTO) {
        productService.delete(deleteRequestDTO);
        return ok().build();
    }

    @PutMapping(SEARCH)
    @ApiOperation(SEARCH_OPERATION)
    public ResponseEntity<?> search(@RequestBody ProductSearchRequestDTO productSearchRequestDTO,
                                    @RequestParam("page") int page,
                                    @RequestParam("size") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ok(productService.search(productSearchRequestDTO, pageable));
    }

    @GetMapping(DETAIL + ID_PATH_VARIABLE_BASE)
    @ApiOperation(DETAILS_OPERATION)
    public ResponseEntity<?> fetchProductDetails(@PathVariable("id") Long id) {
        return ok(productService.fetchDetails(id));
    }

    @GetMapping(MIN)
    @ApiOperation(FETCH_PRODUCT_FOR_DROP_DOWN_OPERATION)
    public ResponseEntity<?> fetchDropDownList() {
        return ok(productService.fetchProductForDropdown());
    }

    @GetMapping(ACTIVE + MIN)
    @ApiOperation(FETCH_DETAILS_FOR_DROPDOWN)
    public ResponseEntity<?> fetchActiveDropDownList() {
        return ok(productService.fetchActiveDropDownList());
    }
}
