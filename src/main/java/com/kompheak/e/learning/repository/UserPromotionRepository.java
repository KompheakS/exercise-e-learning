package com.kompheak.e.learning.repository;

import com.kompheak.e.learning.entity.UserPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPromotionRepository extends JpaRepository<UserPromotion, Long> {
}
