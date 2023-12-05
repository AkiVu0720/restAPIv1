package com.ra.practice.mapper;

import com.ra.practice.dto.request.ProductRequestDeleteDTO;
import com.ra.practice.dto.response.ProductResponseDeleteDTO;
import com.ra.practice.model.ProductModel;
import com.ra.practice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDeleteMapper implements GenericMapper<ProductModel, ProductRequestDeleteDTO, ProductResponseDeleteDTO>  {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public ProductModel toEntity(ProductRequestDeleteDTO productRequestDeleteDTO) {
        return ProductModel.builder()
                .productId(productRequestDeleteDTO.getProductId())
                .build();
    }

    @Override
    public ProductResponseDeleteDTO toResponse(ProductModel productModel) {
        return ProductResponseDeleteDTO.builder()
                .productId(productModel.getProductId())
                .productName(productModel.getProductName())
                .catalogId(productModel.getCatalog().getCatalogId())
                .catalogName(productModel.getCatalog().getCatalogName())
                .status(productModel.isStatus())
                .build();
    }
}
