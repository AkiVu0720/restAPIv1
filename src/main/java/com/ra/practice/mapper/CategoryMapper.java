package com.ra.practice.mapper;

import com.ra.practice.dto.request.CategoryRequestDTO;
import com.ra.practice.dto.response.CategoryResponseDTO;
import com.ra.practice.dto.response.CategoryResponseDTOAll;
import com.ra.practice.model.CategoryModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements GenericMapper<CategoryModel, CategoryRequestDTO, CategoryResponseDTO>{
    @Override
    public CategoryModel toEntity(CategoryRequestDTO cateRequest) {
        return CategoryModel.builder()
                .catalogId(cateRequest.getCatalogId())
                .catalogName(cateRequest.getCatalogName())
                .descriptions(cateRequest.getDescriptions())
                .priority(cateRequest.getPriority())
                .catalogStatus(cateRequest.isCatalogStatus())
                .build();
    }

    @Override
    public CategoryResponseDTO toResponse(CategoryModel categoryModel) {
        return CategoryResponseDTO.builder()
                .catalogId(categoryModel.getCatalogId())
                .catalogName(categoryModel.getCatalogName())
                .priority(categoryModel.getPriority())
                .catalogStatus(categoryModel.isCatalogStatus())
                .build();
    }
    public CategoryResponseDTOAll toResponsev2(CategoryModel categoryModel) {
        return CategoryResponseDTOAll.builder()
                .catalogId(categoryModel.getCatalogId())
                .catalogName(categoryModel.getCatalogName())
                .descriptions(categoryModel.getDescriptions())
                .priority(categoryModel.getPriority())
                .catalogStatus(categoryModel.isCatalogStatus())
                .build();
    }
}
