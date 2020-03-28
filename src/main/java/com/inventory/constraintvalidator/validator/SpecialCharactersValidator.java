package com.inventory.constraintvalidator.validator;

import com.inventory.constraintvalidator.SpecialCharacters;
import com.inventory.utils.commons.PatternUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class SpecialCharactersValidator implements ConstraintValidator<SpecialCharacters, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Objects.isNull(value) || !PatternUtils.hasSpecialCharacter(value);
    }
}
