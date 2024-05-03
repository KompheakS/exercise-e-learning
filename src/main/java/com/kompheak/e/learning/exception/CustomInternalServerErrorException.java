package com.kompheak.e.learning.exception;

public class CustomInternalServerErrorException extends RuntimeException{
    public CustomInternalServerErrorException(){}

    public CustomInternalServerErrorException(String message){
        super(message);
    }
}
