package com.kompheak.e.learning.repository;

import com.kompheak.e.learning.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> getCategoriesByCategoryId(Long categoryId);
}
