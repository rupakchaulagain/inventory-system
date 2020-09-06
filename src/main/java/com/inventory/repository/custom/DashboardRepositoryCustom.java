package com.inventory.repository.custom;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Qualifier("dashboardRepositoryCustom")
public interface DashboardRepositoryCustom {
    
    Optional<Double> findDailyRevenue();

    Optional<Double> findWeeklyRevenue();

    Optional<Double> findMonthlyRevenue();

    Optional<Double> findYearlyRevenue();
}
