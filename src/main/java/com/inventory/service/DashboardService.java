package com.inventory.service;

import com.inventory.dto.response.dashboard.DashboardTilesResponseDTO;
import com.inventory.dto.response.dashboard.DashboardTrafficAndSaleResponseDTO;

public interface DashboardService {
    DashboardTilesResponseDTO fetchDashboardTiles();

    DashboardTrafficAndSaleResponseDTO fetchTrafficAndSalesStatics();
}
