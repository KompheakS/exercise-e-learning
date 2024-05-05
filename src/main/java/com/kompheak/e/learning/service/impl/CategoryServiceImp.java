package com.kompheak.e.learning.service.impl;

import com.kompheak.e.learning.dto.request.CategoryRequest;
import com.kompheak.e.learning.dto.response.ApiResponseDto;
import com.kompheak.e.learning.dto.response.ApiResponseDtoDetails;
import com.kompheak.e.learning.dto.response.CategoryResponse;
import com.kompheak.e.learning.entity.Category;
import com.kompheak.e.learning.exception.CustomInternalServerErrorException;
import com.kompheak.e.learning.exception.CustomNotFoundException;
import com.kompheak.e.learning.mapper.CategoryMapper;
import com.kompheak.e.learning.repository.CategoryRepository;
import com.kompheak.e.learning.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    public CategoryServiceImp(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ApiResponseDto addCategory(CategoryRequest request) {
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());

        try {
            categoryRepository.save(category);
        }catch (Exception exception){
            log.warn("error while create new category");
            throw new CustomInternalServerErrorException("error while create new category");
        }
        log.info("new category has been created");
        return new ApiResponseDto(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED.value());
    }

    @Override
    public ApiResponseDtoDetails<CategoryResponse> getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> {
                    log.warn("category not found with this id: {}", categoryId);
                    return new CustomNotFoundException("category not found!");
                });
        log.info("Category found with ID: {}", categoryId);
        CategoryResponse response = new CategoryResponse();
        response.setCategoryName(category.getCategoryName());

        return new ApiResponseDtoDetails<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), response);
    }

    @Override
    public ApiResponseDto deleteCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> {
                    log.warn("category not found with this id: {}", categoryId);
                    return new CustomNotFoundException("category not found!");
                });

        categoryRepository.delete(category);
        log.info("Category has been deleted, Id: {}", categoryId);

        return new ApiResponseDto(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
    }

    @Override
    public ApiResponseDtoDetails<List<CategoryResponse>> getAllCategory() {
        List<CategoryResponse> responseList = categoryRepository.findAll().stream()
                .map(category -> categoryMapper.mapToCategoryResponse(category))
                .collect(Collectors.toList());
        return new ApiResponseDtoDetails<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), responseList);
    }
}
