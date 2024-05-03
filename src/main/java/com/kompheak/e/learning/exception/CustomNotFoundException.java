package com.kompheak.e.learning.exception;

public class CustomNotFoundException extends RuntimeException{
    public CustomNotFoundException(){}

    public CustomNotFoundException(String message){
        super(message);
    }
}
