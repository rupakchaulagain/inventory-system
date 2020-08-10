package com.inventory.utils.Product;

import com.inventory.dto.request.product.ProductRequestDTO;
import com.inventory.model.Product;
import com.inventory.model.ProductCategory;
import com.inventory.model.ProductPrice;

import java.util.Random;

import static com.inventory.constants.StatusConstants.ACTIVE;

/**
 * @author Rupak
 */
public class ProductUtils {

    public static Product parseToProduct(ProductRequestDTO requestDTO, ProductPrice productPrice, ProductCategory productCategory) {

        Product product = new Product();
        product.setProductCategoryId(productCategory);
        product.setProductType(requestDTO.getProductType());
        product.setProductCode(String.valueOf(new Random().nextInt(100)));
        product.setProductName(requestDTO.getProductName());
        product.setProductDescription(requestDTO.getProductDescription());
        product.setProductQuantity(requestDTO.getProductQuantity());
        product.setStatus(ACTIVE);
        product.setProductPrice(productPrice);

        return product;
    }

    public static ProductPrice parseToProductPrice(ProductRequestDTO requestDTO) {

        ProductPrice productPrice = new ProductPrice();
        productPrice.setCostPrice(Double.parseDouble(requestDTO.getProductCostPrice()));

        if (requestDTO.getProductDiscountAmount() != null) {
            productPrice.setDiscountAmount(Double.parseDouble(requestDTO.getProductDiscountAmount()));
        }
        if (requestDTO.getProductDiscountPercentage() != null) {
            productPrice.setDiscountPercentage(Double.parseDouble(requestDTO.getProductDiscountPercentage()));
        }
        productPrice.setSellingPrice(Double.parseDouble(requestDTO.getProductSellingPrice()));
        productPrice.setStatus(ACTIVE);

        return productPrice;
    }
}
