package com.kompheak.e.learning.controller;

import com.kompheak.e.learning.dto.request.CategoryRequest;
import com.kompheak.e.learning.dto.response.ApiResponseDto;
import com.kompheak.e.learning.dto.response.ApiResponseDtoDetails;
import com.kompheak.e.learning.dto.response.CategoryResponse;
import com.kompheak.e.learning.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponseDto> createNewCategory(@RequestBody CategoryRequest request){
        log.info("Creating a new category...");
        return new ResponseEntity<>(categoryService.addCategory(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<ApiResponseDtoDetails<CategoryResponse>> getCategoryById(@PathVariable("id") Long id){
        log.info("Fetching category by ID: {}", id);
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<ApiResponseDto> deleteCategoryById(@PathVariable("id") Long categoryId){
        log.info("Delete category by ID: {}", categoryId);
        return new ResponseEntity<>(categoryService.deleteCategoryById(categoryId), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponseDtoDetails<List<CategoryResponse>>> getAllCategory(){
        log.info("Get all Category....");
        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
    }

}
