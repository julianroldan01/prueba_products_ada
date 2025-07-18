package com.prueba_ada.prueba_ada.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(String mensaje) {
        super(mensaje);
    }

    public BadRequestException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
