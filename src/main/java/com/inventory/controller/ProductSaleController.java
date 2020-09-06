package com.inventory.controller;


import com.inventory.dto.request.productSale.ProductSaleRequestDTO;
import com.inventory.dto.request.productSale.SaleSearchRequestDTO;
import com.inventory.service.ProductSaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import static com.inventory.constants.SwaggerConstants.ProductConstant.BASE_API_VALUE;
import static com.inventory.constants.SwaggerConstants.ProductConstant.SEARCH_OPERATION;
import static com.inventory.constants.SwaggerConstants.ProductSaleConstant.SAVE_OPERATION;
import static com.inventory.constants.WebResourceKeyConstants.API_V1;
import static com.inventory.constants.WebResourceKeyConstants.ProductSaleConstant.BASE_PRODUCT_SALE;
import static com.inventory.constants.WebResourceKeyConstants.SEARCH;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = API_V1 +BASE_PRODUCT_SALE)
@Api(BASE_API_VALUE)
public class ProductSaleController {

    public final ProductSaleService productSaleService;

    public ProductSaleController(ProductSaleService productSaleService) {
        this.productSaleService = productSaleService;
    }

    @PostMapping
    @ApiOperation(SAVE_OPERATION)
    public ResponseEntity<?> save(@Valid @RequestBody ProductSaleRequestDTO requestDTO) {
        productSaleService.save(requestDTO);
        return created(URI.create(API_V1 + BASE_PRODUCT_SALE)).build();
    }


    @PutMapping(SEARCH)
    @ApiOperation(SEARCH_OPERATION)
    public ResponseEntity<?> search(@RequestBody SaleSearchRequestDTO saleSearchRequestDTO,
                                    @RequestParam("page") int page,
                                    @RequestParam("size") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ok(productSaleService.search(saleSearchRequestDTO, pageable));
    }

}
