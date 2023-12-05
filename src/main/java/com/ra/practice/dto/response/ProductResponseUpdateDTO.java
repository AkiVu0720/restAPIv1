package com.ra.practice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponseUpdateDTO {
    private String productId;
    private String productName;
    private float price;
    private Date created;
    private int quantity;
    private  boolean status;
    private int catalogId;
    private String catalogName;
}
