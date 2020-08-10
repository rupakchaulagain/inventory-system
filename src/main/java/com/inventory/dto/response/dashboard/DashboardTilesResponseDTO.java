package com.inventory.dto.response.dashboard;

import lombok.*;

import java.io.Serializable;

/**
 * @author rupak ON 2020/08/10-9:34 PM
 */
@Getter
@Setter
@Builder
@NoArgsConstructor@AllArgsConstructor
public class DashboardTilesResponseDTO implements Serializable {

    private Long productNumber;

    private Long supplierNumber;

}
