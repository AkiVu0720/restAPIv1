package com.ra.practice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class ProductResponseDeleteDTO {
    private String productId;
    private String productName;
    private boolean status;
    private int catalogId;
    private String catalogName;
}
