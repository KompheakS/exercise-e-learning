package com.kompheak.e.learning.service;

import com.kompheak.e.learning.dto.request.CategoryRequest;
import com.kompheak.e.learning.dto.response.ApiResponseDto;
import com.kompheak.e.learning.dto.response.ApiResponseDtoDetails;
import com.kompheak.e.learning.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    ApiResponseDto addCategory(CategoryRequest request);
    ApiResponseDtoDetails<CategoryResponse> getCategoryById(Long categoryId);
    ApiResponseDto deleteCategoryById(Long categoryId);
    ApiResponseDtoDetails<List<CategoryResponse>> getAllCategory();
}
