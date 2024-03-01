package com.cn.catering.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class AuthException extends Exception{

    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable t) {
        super(message, t);
    }

}
