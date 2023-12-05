package com.ra.practice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductModel {
    @Id
    @Column(name = "product_id",columnDefinition = "varchar(5)")
    private String productId;
    @Column(name = "product_name", columnDefinition = "varchar(100)", unique = true,nullable = false)
    private String productName;

    @Column(name = "price",nullable = false)
    private float price;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @Column(name = "quantity",columnDefinition = " int default 0")
    private int quantity;

    @Column(name = "status", columnDefinition = "bit default 1")
    private  boolean status;
    @ManyToOne
    @JoinColumn(name = "catalog_id",referencedColumnName = "catalog_id")
    private CategoryModel catalog;
}
