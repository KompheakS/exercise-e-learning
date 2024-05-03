package com.kompheak.e.learning.exception;

public class CustomForbiddenException extends RuntimeException{
    public CustomForbiddenException(){
    }

    public CustomForbiddenException(String message){
        super(message);
    }
}
