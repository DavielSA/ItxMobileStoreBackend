package com.itxmobilestore.config.exceptions.handler;

import com.itxmobilestore.config.exceptions.BadRequestException;
import com.itxmobilestore.config.exceptions.DuplicateException;
import com.itxmobilestore.config.exceptions.NotFoundRequestException;
import com.itxmobilestore.config.exceptions.UnauthorizedException;
import com.itxmobilestore.config.exceptions.response.ServiceExceptionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class VSExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(VSExceptionHandler.class);

    @Value("${management.debug}")
    private Boolean DEBUG;


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Order(9)
    private ServiceExceptionDto handleRegularException(
            final Exception exception
    ) {
        ServiceExceptionDto serviceExceptionDto = new ServiceExceptionDto(
                "EXCEPTION",
                "500",
                getMessage(exception)
        );
        log.error(exception.toString());
        return serviceExceptionDto;
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @Order(8)
    private ServiceExceptionDto handleUnauthorizedException(
            final Exception exception
    ) {
        ServiceExceptionDto serviceExceptionDto = new ServiceExceptionDto(
                "UNAUTHORIZED_EXCEPTION",
                "UNAUTHORIZED_EXCEPTION",
                getMessage(exception)
        );
        log.error(exception.toString());
        return serviceExceptionDto;
    }

    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Order(7)
    private ServiceExceptionDto handleDuplicateException(
            final Exception exception
    ) {
        ServiceExceptionDto serviceExceptionDto = new ServiceExceptionDto(
                "DUPLICATE_EXCEPTION",
                "DUPLICATE_EXCEPTION",
                getMessage(exception)
        );
        log.warn(exception.toString());
        return serviceExceptionDto;
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @Order(6)
    private ServiceExceptionDto handleNoResourceFoundException(
            final NoResourceFoundException exception
    ) {
        ServiceExceptionDto serviceExceptionDto = new ServiceExceptionDto(
                "RESOURCE_NOT_FOUND",
                "404",
                getMessage(exception)
        );
        log.warn("Recurso no encontrado: " + exception.getMessage());
        return serviceExceptionDto;
    }

    @ExceptionHandler(NotFoundRequestException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @Order(5)
    private ServiceExceptionDto handleNotFoundRequestException(
            final Exception exception
    ) {
        ServiceExceptionDto serviceExceptionDto = new ServiceExceptionDto(
                "NOT_FOUND_REQUEST_EXCEPTION",
                "NOT_FOUND_REQUEST_EXCEPTION",
                getMessage(exception)
        );
        log.warn(exception.toString());
        return serviceExceptionDto;
    }


    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Order(2)
    private ServiceExceptionDto handleBadRequestException(
            final BadRequestException exception
    ) {
        ServiceExceptionDto serviceExceptionDto = new ServiceExceptionDto(
                "BAD_REQUEST_EXCEPTION",
                "BAD_REQUEST_EXCEPTION",
                getMessage(exception)
        );
        log.warn(exception.toString());
        return serviceExceptionDto;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @Order(1)
    private ServiceExceptionDto handleMethodArgumentNotValidException(
            final MethodArgumentNotValidException exception
    ) {
        List<String> errorArray = new ArrayList<>();
        List<String> messagesArray = new ArrayList<>();
        for (ObjectError error : exception.getBindingResult().getAllErrors()) {
            FieldError fieldError = (FieldError) error;
            final String message = String.format("NOT_VALID_EXCEPTION_%s", fieldError.getField());
            messagesArray.add(message);
            errorArray.add(fieldError.getDefaultMessage());
        }
        ServiceExceptionDto serviceExceptionDto = new ServiceExceptionDto(
                "METHOD_ARGUMENT_NOT_VALID_EXCEPTION",
                messagesArray,
                errorArray
        );
        log.warn(exception.toString());
        return serviceExceptionDto;
    }

    /*
    * Get exception message when debug is true for generic types
    * */
    private String getMessage(final Exception exception) {
        return DEBUG ? exception.getMessage() : "";
    }
}
