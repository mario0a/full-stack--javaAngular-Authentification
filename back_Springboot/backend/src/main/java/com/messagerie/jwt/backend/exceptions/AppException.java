package com.messagerie.jwt.backend.exceptions;

import org.springframework.http.HttpStatus;

//creation d'une exception personnalisée et renvoie le message donné et le code HTTP
public class AppException extends RuntimeException {
    private final HttpStatus httpStatus;

    public AppException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
