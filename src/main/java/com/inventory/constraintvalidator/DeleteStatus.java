package com.inventory.constraintvalidator;
import com.inventory.constraintvalidator.validator.DeleteStatusValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {DeleteStatusValidator.class})
public @interface DeleteStatus {

    String message() default "must be Deleted";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
