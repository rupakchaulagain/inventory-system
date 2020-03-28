package com.inventory.dto.request;

import com.inventory.model.ProductPrice;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * @author Rupak
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDTO implements Serializable {

    private String productName;

    private String productCategory;

    private String productCode;

    private String productQuantity;

    private String productDescription;

    private Character status;

    private ProductPriceRequestDTO priceRequestDTO;

}
