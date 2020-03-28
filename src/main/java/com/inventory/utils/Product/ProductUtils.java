package com.inventory.utils.Product;

import com.inventory.dto.request.ProductRequestDTO;
import com.inventory.model.Product;
import com.inventory.model.ProductPrice;

/**
 * @author Rupak
 */
public class ProductUtils {

    public static Product parseToProduct(ProductRequestDTO requestDTO,ProductPrice productPrice) {

        Product product = new Product();
        product.setProductCategory(requestDTO.getProductCategory());
        product.setProductCode(requestDTO.getProductCode());
        product.setProductName(requestDTO.getProductName());
        product.setProductDescription(requestDTO.getProductDescription());
        product.setProductQuantity(requestDTO.getProductQuantity());
        product.setStatus(requestDTO.getStatus());
        product.setProductPrice(productPrice);

        return product;
    }

    public static ProductPrice parseToProductPrice(ProductRequestDTO requestDTO) {

        ProductPrice productPrice = new ProductPrice();
        productPrice.setCostPrice(requestDTO.getPriceRequestDTO().getCostPrice());
        productPrice.setDiscountAmount(requestDTO.getPriceRequestDTO().getDiscountAmount());
        productPrice.setDiscountPercentage(requestDTO.getPriceRequestDTO().getDiscountPercentage());
        productPrice.setSellingPrice(requestDTO.getPriceRequestDTO().getSellingPrice());
        productPrice.setStatus(requestDTO.getPriceRequestDTO().getStatus());

        return productPrice;
    }
}
