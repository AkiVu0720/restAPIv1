package com.ra.practice.service;

import com.ra.practice.dto.request.CategoryRequestDTO;
import com.ra.practice.dto.response.CategoryResponseDTO;
import com.ra.practice.dto.response.CategoryResponseDTOAll;
import com.ra.practice.model.CategoryModel;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> findAll();
    CategoryResponseDTO findResponseById(int catalogId);
    CategoryModel findById(int catalogId);
    CategoryResponseDTOAll save(CategoryRequestDTO categoryRequest);
    CategoryResponseDTO delete(int catalogId);
    CategoryResponseDTO findByName(String catalogName);
    CategoryResponseDTOAll update (CategoryRequestDTO category, int categoryId);


}
