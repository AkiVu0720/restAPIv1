package com.ra.practice.mapper;

import com.ra.practice.dto.request.ProductRequestDTO;
import com.ra.practice.dto.response.ProductResponseDTO;
import com.ra.practice.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper  implements GenericMapper<ProductModel, ProductRequestDTO, ProductResponseDTO>{
    @Override
    public ProductModel toEntity(ProductRequestDTO productRequest) {
        return ProductModel.builder()
                .productId(productRequest.getProductId())
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .status(productRequest.isStatus())
                .build();
    }

    @Override
    public ProductResponseDTO toResponse(ProductModel productModel) {

        return ProductResponseDTO.builder()
                .productId(productModel.getProductId())
                .productName(productModel.getProductName())
                .price(productModel.getPrice())
                .quantity(productModel.getQuantity())
                .status(productModel.isStatus())
                .build();
    }
}
