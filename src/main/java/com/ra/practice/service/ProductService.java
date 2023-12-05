package com.ra.practice.service;

import com.ra.practice.dto.request.ProductRequestCreatDTO;
import com.ra.practice.dto.request.ProductRequestDeleteDTO;
import com.ra.practice.dto.request.ProductRequestUpdateDTO;
import com.ra.practice.dto.response.ProductResponseDeleteDTO;
import com.ra.practice.dto.response.ProductResponseUpdateDTO;

import java.util.List;

public interface ProductService {
    List<ProductResponseUpdateDTO> findAll();
    List<ProductResponseUpdateDTO> findByProductNameOrCategoryName(String searchName);
    ProductResponseUpdateDTO save(ProductRequestCreatDTO creatDTO);
    ProductResponseDeleteDTO saveAfterDelete(ProductRequestDeleteDTO updateDTO);

    ProductResponseUpdateDTO updateProduct(ProductRequestUpdateDTO updateDTO, String productId);
    ProductResponseDeleteDTO setStatusFalse(String Id);

}
