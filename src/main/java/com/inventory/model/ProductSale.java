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
    @JoinColumn(name = "product_id")
    private Product productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplierId;

    @Temporal(TemporalType.DATE)
    @Column(name = "sale_date")
    private Date saleDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sale_time")
    private Date saleTime;


    @Column(name = "selling_price")
    private Double sellingPrice;

    @Column(name = "discount_amount")
    private Double totalAmount;

    @Column(name = "status")
    private Character status;

    @Column(name = "remarks")
    private String remarks;

}

