package com.ra.practice.serviceImp;

import com.ra.practice.dto.request.CategoryRequestDTO;
import com.ra.practice.dto.response.CategoryResponseDTO;
import com.ra.practice.dto.response.CategoryResponseDTOFull;
import com.ra.practice.mapper.CategoryMapper;
import com.ra.practice.model.CategoryModel;
import com.ra.practice.repository.CategoryRepository;
import com.ra.practice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private  CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<CategoryResponseDTO> findAll() {
        return categoryRepository.findAll().stream().map(categoryModel -> categoryMapper.toResponse(categoryModel)).collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDTO findById(int catalogId) {
        Optional<CategoryModel> category = categoryRepository.findById(catalogId);
        if (category.isPresent()) {
            return categoryMapper.toResponse(category.get());
        }
        return null;
    }

    @Override
    public CategoryResponseDTOFull save(CategoryRequestDTO categoryRequest) {
        return categoryMapper.toResponsev2(categoryRepository.save(categoryMapper.toEntity(categoryRequest)));
    }

    @Override
    public CategoryResponseDTO delete(int catalogId) {
        Optional<CategoryModel> category = categoryRepository.findById(catalogId);
        if (category.isPresent()){
            categoryRepository.delete(category.get());
            return categoryMapper.toResponse(category.get());
        }
        return null;
    }

    @Override
    public CategoryResponseDTO findByName(String catalogName) {
        CategoryModel category = categoryRepository.findByCatalogNameContaining(catalogName);
        if (category!=null){
            return categoryMapper.toResponse(category);
        }
        return null;
    }

    @Override
    public CategoryResponseDTOFull update(CategoryRequestDTO categoryRequest,int categoryId) {
        Optional<CategoryModel> category = categoryRepository.findById(categoryId);
        if (category.isPresent()){
            CategoryModel categoryUpdate = category.get();
            categoryUpdate.setCatalogId(categoryRequest.getCatalogId());
            categoryUpdate.setCatalogName(categoryRequest.getCatalogName());
            categoryUpdate.setDescriptions(categoryRequest.getDescriptions());
            categoryUpdate.setPriority(categoryRequest.getPriority());
            categoryUpdate.setCatalogStatus(categoryRequest.isCatalogStatus());
            return categoryMapper.toResponsev2(categoryRepository.save(categoryUpdate));
        }
        return null;
    }

}
