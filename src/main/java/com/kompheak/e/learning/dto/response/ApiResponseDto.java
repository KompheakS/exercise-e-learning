package com.kompheak.e.learning.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ApiResponseDto {
    private String message;
    private int status;
}
