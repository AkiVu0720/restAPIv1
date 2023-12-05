package com.ra.practice.controller;

import com.ra.practice.dto.request.ProductRequestCreatDTO;
import com.ra.practice.dto.request.ProductRequestDeleteDTO;
import com.ra.practice.dto.request.ProductRequestUpdateDTO;
import com.ra.practice.dto.response.ProductResponseDeleteDTO;
import com.ra.practice.dto.response.ProductResponseUpdateDTO;
import com.ra.practice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public ResponseEntity<?>findAll(){
        List<ProductResponseUpdateDTO> creatDTO = productService.findAll();
        return new ResponseEntity<>(creatDTO, HttpStatus.OK);
    }
    @PostMapping
    public  ResponseEntity<?>create(@RequestBody ProductRequestCreatDTO productDTO){
        ProductResponseUpdateDTO createDTO = productService.save(productDTO);
        return new ResponseEntity<>(createDTO,HttpStatus.CREATED);
    }
    @PutMapping("/{productId}")
    public ResponseEntity<?>update(@RequestBody ProductRequestUpdateDTO updateDTO, @PathVariable String productId){
        ProductResponseUpdateDTO productUpdateDTO = productService.updateProduct(updateDTO,productId);

        return  new ResponseEntity<>(productUpdateDTO, HttpStatus.OK);
    }
    @GetMapping("/{searchName}")
    public ResponseEntity<?>search(@PathVariable String searchName){
        List<ProductResponseUpdateDTO> productSearchDTO = productService.findByProductNameOrCategoryName(searchName);
        return new ResponseEntity<>(productSearchDTO,HttpStatus.OK);
    }
    @GetMapping("/{productId}")
    private ResponseEntity <?> setStatus (@PathVariable String productId){
        ProductResponseDeleteDTO productDeleteDTO = productService.setStatusFalse(productId);
        return new ResponseEntity<>(productDeleteDTO,HttpStatus.OK);
    }

}
