package com.kompheak.e.learning.exception;

public class CustomBadRequestException extends RuntimeException{
    public CustomBadRequestException(){
        super();
    }
    public CustomBadRequestException(String message){
        super(message);
    }
}
