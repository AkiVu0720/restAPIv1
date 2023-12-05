package com.ra.practice.repository;

import com.ra.practice.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
    CategoryModel findByCatalogNameContaining(String catalogName);
}
