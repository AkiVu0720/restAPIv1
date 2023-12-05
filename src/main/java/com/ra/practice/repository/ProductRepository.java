package com.ra.practice.repository;

import com.ra.practice.dto.response.ProductResponseUpdateDTO;
import com.ra.practice.model.CategoryModel;
import com.ra.practice.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,String> {
 @Query ("select pd from ProductModel pd inner join CategoryModel ct  on pd.catalog.catalogId = ct.catalogId where  ct.catalogName like %?1% or  pd.productName like %?1%")
 List<ProductModel> findByProductNameOrCatalog_CatalogName(String catalogName);
// @Query("select  pd from  ProductModel  pd ")
// ProductModel setStatusFalse(String productId);
}
