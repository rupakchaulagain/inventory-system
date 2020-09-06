package com.inventory.service.impl;

import com.inventory.dto.response.dashboard.DashboardTilesResponseDTO;
import com.inventory.dto.response.dashboard.DashboardTrafficAndSaleResponseDTO;
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

        Double totalRevenue = dashboardRepository.findTotalRevenueGenerated()
                .orElse(0D);

        return DashboardTilesResponseDTO.builder()
                .productNumber(productNumber)
                .supplierNumber(supplierNumber)
                .totalRevenue(totalRevenue)
                .build();
    }

    @Override
    public DashboardTrafficAndSaleResponseDTO fetchTrafficAndSalesStatics() {
        Double dailyRevenue = dashboardRepository.findDailyRevenue()
                .orElse(0D);
        Double weeklyRevenue = dashboardRepository.findWeeklyRevenue()
                .orElse(0D);

        Double monthlyRevenue = dashboardRepository.findMonthlyRevenue()
                .orElse(0D);

        Double yearlyRevenue = dashboardRepository.findYearlyRevenue()
                .orElse(0D);

        return DashboardTrafficAndSaleResponseDTO.builder()
                .dailyRevenue(dailyRevenue)
                .weeklyRevenue(weeklyRevenue)
                .monthlyRevenue(monthlyRevenue)
                .yearlyRevenue(yearlyRevenue)
                .build();
    }
}
