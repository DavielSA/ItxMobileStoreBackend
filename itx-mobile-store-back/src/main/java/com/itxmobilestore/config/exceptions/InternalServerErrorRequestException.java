package com.itxmobilestore.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorRequestException extends RuntimeException {

    public InternalServerErrorRequestException(String errorMessage) { super(errorMessage); }
}
