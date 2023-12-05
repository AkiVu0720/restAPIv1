package com.ra.practice.service;

import com.ra.practice.dto.request.CategoryRequestDTO;
import com.ra.practice.dto.response.CategoryResponseDTO;
import com.ra.practice.dto.response.CategoryResponseDTOFull;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> findAll();
    CategoryResponseDTO findById(int catalogId);
    CategoryResponseDTOFull save(CategoryRequestDTO categoryRequest);
    CategoryResponseDTO delete(int catalogId);
    CategoryResponseDTO findByName(String catalogName);
    CategoryResponseDTOFull update (CategoryRequestDTO category, int categoryId);


}
