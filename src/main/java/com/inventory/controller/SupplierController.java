package com.inventory.controller;

import com.inventory.dto.commons.DeleteRequestDTO;
import com.inventory.dto.request.supplier.SupplierRequestDTO;
import com.inventory.dto.request.supplier.SupplierSearchRequestDTO;
import com.inventory.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static com.inventory.constants.SwaggerConstants.ProductConstant.*;
import static com.inventory.constants.SwaggerConstants.SupplierConstant.BASE_API_VALUE;
import static com.inventory.constants.SwaggerConstants.SupplierConstant.SAVE_OPERATION;
import static com.inventory.constants.WebResourceKeyConstants.*;
import static com.inventory.constants.WebResourceKeyConstants.SupplierConstant.BASE_SUPPLIER;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

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
    @ApiOperation(SAVE_OPERATION)
    public ResponseEntity<?> save(@Valid @RequestBody SupplierRequestDTO requestDTO) {
        supplierService.save(requestDTO);
        return created(URI.create(API_V1 + BASE_SUPPLIER)).build();
    }

    @DeleteMapping
    @ApiOperation(DELETE_OPERATION)
    public ResponseEntity<?> delete( @RequestBody DeleteRequestDTO deleteRequestDTO) {
        supplierService.delete(deleteRequestDTO);
        return ok().build();
    }

    @GetMapping(DETAIL + ID_PATH_VARIABLE_BASE)
    @ApiOperation(DETAILS_OPERATION)
    public ResponseEntity<?> fetchSupplierDetails(@PathVariable("id") Long id) {
        return ok(supplierService.fetchDetails(id));
    }


    @PutMapping(SEARCH)
    @ApiOperation(SEARCH_OPERATION)
    public ResponseEntity<?> search(@RequestBody SupplierSearchRequestDTO supplierSearchRequestDTO,
                                    @RequestParam("page") int page,
                                    @RequestParam("size") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ok(supplierService.search(supplierSearchRequestDTO, pageable));
    }

    @GetMapping(ACTIVE + MIN)
    @ApiOperation(FETCH_DETAILS_FOR_DROPDOWN)
    public ResponseEntity<?> fetchActiveDropDownList() {
        return ok(supplierService.fetchActiveDropDownList());
    }

}
