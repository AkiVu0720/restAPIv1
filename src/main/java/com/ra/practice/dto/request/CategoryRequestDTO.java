package com.ra.practice.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryRequestDTO {
    private  int catalogId;
    @NotNull(message = "Tên nhân viên không được null")
    private  String catalogName;
    private  String descriptions;
    private  int priority;
    private  boolean catalogStatus;

}
