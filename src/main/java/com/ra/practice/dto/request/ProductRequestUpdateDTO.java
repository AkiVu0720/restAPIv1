package com.ra.practice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequestUpdateDTO {
    private String productId;
    private String productName;
    private float price;
    private boolean status;
    private int catalogId;
}
