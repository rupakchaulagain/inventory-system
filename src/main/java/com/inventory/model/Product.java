package com.inventory.model;

import com.inventory.configuration.Auditable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Rupak
 */
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategoryId;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "product_quantity", nullable = false)
    private Long productQuantity;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_price")
    private ProductPrice productPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;


    @Column(name = "remarks")
    private String remarks;


    @Column(name = "status")
    private Character status;
}
