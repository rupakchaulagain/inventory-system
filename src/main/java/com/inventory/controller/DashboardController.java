package com.inventory.controller;

import com.inventory.service.DashboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.inventory.constants.SwaggerConstants.ProductConstant.BASE_API_VALUE;
import static com.inventory.constants.SwaggerConstants.ProductConstant.FETCH_PRODUCT_FOR_DROP_DOWN_OPERATION;
import static com.inventory.constants.WebResourceKeyConstants.API_V1;
import static com.inventory.constants.WebResourceKeyConstants.DashboardConstant.*;
import static org.springframework.http.ResponseEntity.ok;

/**
 * @author rupak ON 2020/07/15-10:27 AM
 */
@RestController
@RequestMapping(value = API_V1 +BASE_DASHBOARD)
@Api(BASE_API_VALUE)
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping(TILES_STATICS)
    @ApiOperation(FETCH_PRODUCT_FOR_DROP_DOWN_OPERATION)
    public ResponseEntity<?> fetchDashboardTiles() {
        return ok(dashboardService.fetchDashboardTiles());
    }

    @GetMapping(DAILY_REVENUE_STATICS)
    @ApiOperation(FETCH_PRODUCT_FOR_DROP_DOWN_OPERATION)
    public ResponseEntity<?> fetchTrafficAndSalesStatics() {
        return ok(dashboardService.fetchTrafficAndSalesStatics());
    }


}
