package com.inventory.model;

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
@Table(name = "product_price")
public class ProductPrice implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cost_price")
    private Double costPrice;

    @Column(name = "selling_price")
    private Double sellingPrice;

    @Column(name = "discount_amount")
    private Double discountAmount;

    @Column(name = "discount_percentage")
    private Double discountPercentage;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "status")
    private Character status;


}
