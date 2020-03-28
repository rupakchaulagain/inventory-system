package com.inventory.exception.utils;
import com.inventory.constants.StringConstant;
import com.inventory.exception.ConstraintViolationException;
import com.inventory.utils.commons.StringUtil;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.capitalize;

public class ValidationUtils {

    public static String getExceptionForMethodArgumentNotValid(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {

        List<String> violations = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> {
                            return capitalize(StringUtil.splitByCharacterTypeCamelCase(
                                    error.getField())) + StringConstant.SPACE + error.getDefaultMessage();
                        }
                ).collect(Collectors.toList());

        return String.join(StringConstant.COMMA_SEPARATED + StringConstant.SPACE, violations);
    }

    /*
    ConstraintViolationException to be thrown when validation on an argument annotated with {@code @Valid}
   (request dtos) fails on Service layer
  */
    public static <T> void validateConstraintViolation(Set<ConstraintViolation<T>> constraintViolations) {
        if (!constraintViolations.isEmpty()) {
            List<String> violations = constraintViolations.stream().map(
                    violation -> {
                        return capitalize(StringUtil.splitByCharacterTypeCamelCase(
                                violation.getPropertyPath().toString())) + StringConstant.SPACE + violation.getMessage();
                    }
            ).collect(Collectors.toList());

            String errorMessages = String.join(StringConstant.COMMA_SEPARATED + StringConstant.SPACE, violations);

            throw new ConstraintViolationException(errorMessages, errorMessages);
        }
    }
}
