package com.kompheak.e.learning.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponseDtoDetails<T>{
    private String message;
    private int status;
    private T data;
}
