package com.ra.practice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryModel {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private  int catalogId;
    @Column(name = "catalog_name",columnDefinition = "varchar(100)",unique = true)
    private  String catalogName;
    @Column(name = "descriptions")
    private  String descriptions;
    @Column(name = "priority")
    private  int priority;
    @Column(name = "catalog_Status", columnDefinition = "bit default 1")
    private  boolean catalogStatus;
    @OneToMany (mappedBy = "catalog")
    List<ProductModel> listProduct;
}
