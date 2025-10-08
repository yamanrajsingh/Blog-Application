package com.yrs.blog.blogappapis.exceptions;

public class ApiExceptionHandler extends RuntimeException{

    public ApiExceptionHandler() {
    }

    public ApiExceptionHandler(String message) {
        super(message);
    }
}
