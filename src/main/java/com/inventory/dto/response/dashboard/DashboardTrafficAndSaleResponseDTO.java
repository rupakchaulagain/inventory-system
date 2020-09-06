package com.inventory.dto.response.dashboard;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardTrafficAndSaleResponseDTO {

    private Double dailyRevenue;

    private Double weeklyRevenue;

    private Double monthlyRevenue;

    private Double yearlyRevenue;
}
