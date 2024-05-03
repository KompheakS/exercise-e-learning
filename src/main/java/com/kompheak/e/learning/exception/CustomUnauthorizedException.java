package com.kompheak.e.learning.exception;

public class CustomUnauthorizedException extends RuntimeException{
    public CustomUnauthorizedException(){}

    public CustomUnauthorizedException(String message){
        super(message);
    }
}
