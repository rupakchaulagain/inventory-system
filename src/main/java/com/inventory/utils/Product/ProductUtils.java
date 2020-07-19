package com.inventory.utils.Product;

import com.inventory.dto.request.product.ProductRequestDTO;
import com.inventory.model.Product;
import com.inventory.model.ProductPrice;

/**
 * @author Rupak
 */
public class ProductUtils {

    public static Product parseToProduct(ProductRequestDTO requestDTO,ProductPrice productPrice) {

        Product product = new Product();
        product.setProductCategory(requestDTO.getProductCategory());
        product.setProductType(requestDTO.getProductType());
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
        productPrice.setCostPrice(requestDTO.getCostPrice());
        productPrice.setDiscountAmount(requestDTO.getDiscountAmount());
        productPrice.setDiscountPercentage(requestDTO.getDiscountPercentage());
        productPrice.setSellingPrice(requestDTO.getSellingPrice());
        productPrice.setStatus(requestDTO.getStatus());

        return productPrice;
    }
}
