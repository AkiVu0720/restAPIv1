package com.ra.practice.serviceImp;

import com.ra.practice.dto.request.ProductRequestCreatDTO;
import com.ra.practice.dto.request.ProductRequestDeleteDTO;
import com.ra.practice.dto.request.ProductRequestUpdateDTO;
import com.ra.practice.dto.response.ProductResponseDeleteDTO;
import com.ra.practice.dto.response.ProductResponseUpdateDTO;
import com.ra.practice.mapper.ProductDeleteMapper;
import com.ra.practice.mapper.ProductMapper;
import com.ra.practice.model.CategoryModel;
import com.ra.practice.model.ProductModel;
import com.ra.practice.repository.CategoryRepository;
import com.ra.practice.repository.ProductRepository;
import com.ra.practice.service.CategoryService;
import com.ra.practice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductDeleteMapper productDeleteMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseUpdateDTO> findAll() {
        return productRepository.findAll().stream().map(productModel ->
                productMapper.toResponse(productModel))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseUpdateDTO> findByProductNameOrCategoryName(String searchName) {
        return productRepository.findByProductNameOrCatalog_CatalogName(searchName)
                .stream().map(productModel ->
                        productMapper.toResponse(productModel))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseUpdateDTO save(ProductRequestCreatDTO updateDTO) {

        return productMapper.toResponse(productRepository.save(productMapper.toEntity(updateDTO)));
    }

    @Override
    public ProductResponseDeleteDTO saveAfterDelete(ProductRequestDeleteDTO updateDTO) {
        return null;
    }

    @Override
    public ProductResponseUpdateDTO updateProduct(ProductRequestUpdateDTO updateDTO, String productId) {
        Optional<ProductModel> productModel = productRepository.findById(productId);
        CategoryModel categoryModel = categoryRepository.findById(updateDTO.getCatalogId()).get();
        if (productModel.isPresent()){
            ProductModel productUpdate = productModel.get();
            productUpdate.setProductId(updateDTO.getProductId());
            productUpdate.setProductName(updateDTO.getProductName());
            productUpdate.setPrice(updateDTO.getPrice());
            productUpdate.setStatus(updateDTO.isStatus());
            productUpdate.setCatalog(categoryModel);
            return productMapper.toResponse(productRepository.save(productUpdate));
        }
        return null;
    }

    @Override
    public ProductResponseDeleteDTO setStatusFalse(String productId) {
        Optional<ProductModel> productDelete = productRepository.findById(productId);
        if (productDelete.isPresent()){
            ProductModel productUpdate = productDelete.get();
            productUpdate.setStatus(false);
            return productDeleteMapper.toResponse(productRepository.save(productUpdate));
        }

        return null;
    }


}
