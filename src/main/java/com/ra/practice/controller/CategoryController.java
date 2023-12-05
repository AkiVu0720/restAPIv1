package com.ra.practice.controller;

import com.ra.practice.dto.request.CategoryRequestDTO;
import com.ra.practice.dto.response.CategoryResponseDTO;
import com.ra.practice.dto.response.CategoryResponseDTOAll;
import com.ra.practice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<?>getAllCategory(){
        List<CategoryResponseDTO> dtoList = categoryService.findAll();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> createCategory(@Validated @RequestBody CategoryRequestDTO category){
        CategoryResponseDTOAll categoryDTO = categoryService.save(category);
        return new ResponseEntity<>(categoryDTO,HttpStatus.CREATED);
    }
    @GetMapping("/{categoryId}")
    public ResponseEntity<?> findById(@PathVariable int categoryId){
        CategoryResponseDTO categoryDTO = categoryService.findResponseById(categoryId);
        return  new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteById(@PathVariable int categoryId){
        CategoryResponseDTO categoryDTO = categoryService.delete(categoryId);
        return  new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }
    @GetMapping("search/{catalogName}")
    public ResponseEntity<?> findByName(@PathVariable String catalogName){
        CategoryResponseDTO categoryDTO = categoryService.findByName(catalogName);
        return  new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity<?>updateCategory(@RequestBody CategoryRequestDTO categoryRequestDTO, @PathVariable int categoryId){
        CategoryResponseDTOAll category = categoryService.update(categoryRequestDTO,categoryId);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }



}
