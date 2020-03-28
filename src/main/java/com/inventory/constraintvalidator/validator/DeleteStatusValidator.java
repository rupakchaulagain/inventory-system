package com.inventory.constraintvalidator.validator;

import com.inventory.constants.StatusConstants;
import com.inventory.constraintvalidator.DeleteStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class DeleteStatusValidator implements ConstraintValidator<DeleteStatus, Character> {
    @Override
    public boolean isValid(Character status, ConstraintValidatorContext context) {
        if (Objects.isNull(status)) return false;
        return status.equals(StatusConstants.DELETED);
    }
}
