package com.inventory.controller;

import com.inventory.dto.request.ProductRequestDTO;
import com.inventory.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

import static com.inventory.constants.SwaggerConstants.ProductConstant.BASE_API_VALUE;
import static com.inventory.constants.SwaggerConstants.ProductConstant.SAVE_OPERATION;
import static com.inventory.constants.WebResourceKeyConstants.API_V1;
import static com.inventory.constants.WebResourceKeyConstants.ProductConstant.BASE_PRODUCT;
import static org.springframework.http.ResponseEntity.created;

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
}
