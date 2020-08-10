package com.inventory.service.impl;

import com.inventory.dto.response.dashboard.DashboardTilesResponseDTO;
import com.inventory.repository.DashboardRepository;
import com.inventory.service.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rupak ON 2020/08/10-9:37 PM
 */
@Service
@Transactional
@Slf4j
public class DashboardServiceImpl implements DashboardService {

    private final DashboardRepository dashboardRepository;

    public DashboardServiceImpl(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    @Override
    public DashboardTilesResponseDTO fetchDashboardTiles() {

        Long productNumber = dashboardRepository.findNumberOfActiveProducts()
                .orElse(0L);
        Long supplierNumber = dashboardRepository.findNumberOfActiveSupplier()
                .orElse(0L);

        DashboardTilesResponseDTO responseDTO = DashboardTilesResponseDTO.builder()
                .productNumber(productNumber)
                .supplierNumber(supplierNumber)
                .build();


        return responseDTO;
    }
}
