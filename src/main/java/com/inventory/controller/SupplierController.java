package com.inventory.controller;

import com.inventory.constants.SwaggerConstants;
import com.inventory.dto.request.supplier.SupplierRequestDTO;
import com.inventory.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

import static com.inventory.constants.SwaggerConstants.SupplierConstant.BASE_API_VALUE;
import static com.inventory.constants.WebResourceKeyConstants.API_V1;
import static com.inventory.constants.WebResourceKeyConstants.SupplierConstant.BASE_SUPPLIER;
import static org.springframework.http.ResponseEntity.created;

/**
 * @author Rupak
 */
@RestController
@RequestMapping(value = API_V1 + BASE_SUPPLIER)
@Api(BASE_API_VALUE)
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    @ApiOperation(SwaggerConstants.SupplierConstant.SAVE_OPERATION)
    public ResponseEntity<?> save(@Valid @RequestBody SupplierRequestDTO requestDTO) {
        supplierService.save(requestDTO);
        return created(URI.create(API_V1 + BASE_SUPPLIER)).build();
    }

}
