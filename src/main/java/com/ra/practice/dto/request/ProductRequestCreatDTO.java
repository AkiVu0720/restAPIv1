package com.ra.practice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequestCreatDTO {
    private String productId;
    private String productName;
    private float price;
    private int catalogId;
}
