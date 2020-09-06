package com.inventory.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "sale_date")
    private Date saleDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sale_time")
    private Date saleTime;

    @Column(name = "total_quantity")
    private Long totalQuantity;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "status")
    private Character status;

    @Column(name = "remarks")
    private String remarks;


}
