package com.messagerie.jwt.backend.exceptions;

import org.springframework.http.HttpStatus;

public class AppExcetion extends Throwable {
    public AppExcetion(String message, HttpStatus httpStatus) {
    }
}
