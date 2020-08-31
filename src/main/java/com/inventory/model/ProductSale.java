package com.inventory.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author rupak ON 2020/07/23-7:32 PM
 */
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_sale")
public class ProductSale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id")
    private Sale saleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product productId;

    @Column(name = "selling_price")
    private Double sellingPrice;

    @Column(name = "discount_amount")
    private Double discountAmount;

    @Column(name = "status")
    private Character status;

}

