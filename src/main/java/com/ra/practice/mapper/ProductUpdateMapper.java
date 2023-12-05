package com.ra.practice.mapper;

import com.ra.practice.dto.response.ProductResponseUpdateDTO;
import com.ra.practice.model.CategoryModel;
import com.ra.practice.model.ProductModel;
import com.ra.practice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class ProductUpdateMapper implements GenericMapper<ProductModel, ProductResponseUpdateDTO,ProductResponseUpdateDTO>{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public ProductModel toEntity(ProductResponseUpdateDTO updateDTO) {
        CategoryModel categoryModel = categoryRepository.findById(updateDTO.getCatalogId()).get();
        return ProductModel.builder()
                .productId(updateDTO.getProductId())
                .productName(updateDTO.getProductName())
                .price(updateDTO.getPrice())
                .status(updateDTO.isStatus())
                .catalog(categoryModel)
                .build();
    }

    @Override
    public ProductResponseUpdateDTO toResponse(ProductModel productModel) {
        return ProductResponseUpdateDTO.builder()
                .productId(productModel.getProductId())
                .productName(productModel.getProductName())
                .price(productModel.getPrice())
                .created(productModel.getCreated())
                .status(productModel.isStatus())
                .quantity(productModel.getQuantity())
                .catalogId(productModel.getCatalog().getCatalogId())
                .catalogName(productModel.getCatalog().getCatalogName())
                .build();
    }
}
