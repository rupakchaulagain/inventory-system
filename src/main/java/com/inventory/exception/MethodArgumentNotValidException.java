package com.inventory.exception;

import com.inventory.exception.utils.ExceptionUtils;
import com.inventory.exception.utils.ValidationUtils;
import lombok.Getter;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * <p>
 * MethodArgumentNotValidException to be thrown when validation on an argument annotated with {@code @Valid}
 * (request dtos) fails on Controller class
 */
@Getter
public class MethodArgumentNotValidException extends RuntimeException {

    public static ExceptionResponse handleMethodArgumentNotValidException(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {

        String errorMessage = ValidationUtils.getExceptionForMethodArgumentNotValid(ex);

        return ExceptionResponse.builder()
                .errorMessage(errorMessage)
                .debugMessage(errorMessage)
                .responseStatus(BAD_REQUEST)
                .responseCode(BAD_REQUEST.value())
                .timeStamp(ExceptionUtils.getLocalDateTime())
                .build();
    }
}
