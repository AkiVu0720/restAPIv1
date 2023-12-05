package com.ra.practice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponseDTO {
    private String productId;
    private String productName;
    private float price;
    private int quantity;
    private  boolean status;
    private int catalogId;
}
