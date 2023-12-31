package com.ra.practice.mapper;

import com.ra.practice.dto.request.ProductRequestCreatDTO;
import com.ra.practice.dto.response.ProductResponseUpdateDTO;
import com.ra.practice.model.CategoryModel;
import com.ra.practice.model.ProductModel;
import com.ra.practice.repository.CategoryRepository;
import com.ra.practice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper  implements GenericMapper<ProductModel, ProductRequestCreatDTO, ProductResponseUpdateDTO>{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public ProductModel toEntity(ProductRequestCreatDTO productRequest) {
        CategoryModel categoryModel = categoryRepository.findById(productRequest.getCatalogId()).get();
        return ProductModel.builder()
                .productId(productRequest.getProductId())
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
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
                .quantity(productModel.getQuantity())
                .status(productModel.isStatus())
                .catalogId(productModel.getCatalog().getCatalogId())
                .catalogName(productModel.getCatalog().getCatalogName())
                .build();
    }
}
