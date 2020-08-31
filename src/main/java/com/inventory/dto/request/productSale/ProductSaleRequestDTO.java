package com.inventory.dto.request.productSale;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class ProductSaleRequestDTO implements Serializable{

    private List<ProductToSaleRequestDTO> productList;

    private Double totalAmount;

}
