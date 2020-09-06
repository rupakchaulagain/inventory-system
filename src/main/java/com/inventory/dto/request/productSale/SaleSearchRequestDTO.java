package com.inventory.dto.request.productSale;

import lombok.Getter;

import java.util.Date;

@Getter
public class SaleSearchRequestDTO {

    private Date fromDate;
    private Date toDate;
}
