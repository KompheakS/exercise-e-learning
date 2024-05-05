package com.kompheak.e.learning.mapper;

import com.kompheak.e.learning.dto.request.CategoryRequest;
import com.kompheak.e.learning.dto.response.CategoryResponse;
import com.kompheak.e.learning.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    Category mapToCategory(CategoryRequest request);
    CategoryResponse mapToCategoryResponse(Category category);

}
