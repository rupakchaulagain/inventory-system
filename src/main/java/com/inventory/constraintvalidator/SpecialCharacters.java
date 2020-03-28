package com.inventory.constraintvalidator;

import com.inventory.constraintvalidator.validator.SpecialCharactersValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {SpecialCharactersValidator.class})
public @interface SpecialCharacters {
    String message() default "contains special characters";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
