package com.kompheak.e.learning.controller;

import com.kompheak.e.learning.service.UserPromotionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-promotion")
public class UserPromotionController {

    private final UserPromotionService userPromotionService;

    public UserPromotionController(UserPromotionService userPromotionService){
        this.userPromotionService = userPromotionService;
    }

}
