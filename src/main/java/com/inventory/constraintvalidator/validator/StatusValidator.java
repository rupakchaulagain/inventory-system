package com.inventory.constraintvalidator.validator;

import com.inventory.constraintvalidator.Status;
import com.inventory.utils.commons.PatternUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class StatusValidator implements ConstraintValidator<Status, Character> {

    @Override
    public boolean isValid(Character status, ConstraintValidatorContext context) {
        if (Objects.isNull(status)) return false;
        return PatternUtils.isStatusActiveOrInactive(status);
    }
}
