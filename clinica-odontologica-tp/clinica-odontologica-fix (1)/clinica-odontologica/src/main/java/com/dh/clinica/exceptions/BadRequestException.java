package com.dh.clinica.exceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String s) {
        super(s);
    }
    public BadRequestException(String s, Throwable cause) {
        super(s, cause);
    }


}
