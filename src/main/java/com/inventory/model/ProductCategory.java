package com.inventory.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author rupak ON 2020/07/23-7:32 PM
 */
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_category")
public class ProductCategory {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplierId;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Character status;

    @Column(name = "remarks")
    private String remarks;

}
