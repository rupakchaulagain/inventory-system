package com.inventory.exception;

import com.inventory.exception.utils.ExceptionUtils;
import lombok.Getter;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Getter
public class UnauthorisedException extends RuntimeException {

    private ExceptionResponse exception;

    public UnauthorisedException(Class clazz, String debugMessage) {
        super(ExceptionUtils.generateMessage(clazz));
        exception = ExceptionResponse.builder()
                .errorMessage(ExceptionUtils.generateMessage(clazz))
                .debugMessage(debugMessage)
                .responseStatus(UNAUTHORIZED)
                .responseCode(UNAUTHORIZED.value())
                .timeStamp(ExceptionUtils.getLocalDateTime())
                .build();

    }

}
