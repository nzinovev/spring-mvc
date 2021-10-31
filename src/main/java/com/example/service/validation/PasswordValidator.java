package com.example.service.validation;

import com.example.service.validation.annotation.PasswordConstraints;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraints, String> {

    /**
     * At least 8 chars
     * Contains at least one digit
     * Contains at least one lower alpha char and one upper alpha char
     * Contains at least one char within a set of special chars (@#%$^ etc.)
     * Does not contain space, tab, etc.
     */
    //^                 # start-of-string
    //(?=.*[0-9])       # a digit must occur at least once
    //(?=.*[a-z])       # a lower case letter must occur at least once
    //(?=.*[A-Z])       # an upper case letter must occur at least once
    //(?=.*[@#$%^&+=])  # a special character must occur at least once
    //(?=\S+$)          # no whitespace allowed in the entire string
    //.{8,}             # anything, at least eight places though
    //$                 # end-of-string
    private final String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    @Override
    public void initialize(PasswordConstraints constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isNotEmpty(value) && value.matches(passwordRegex);
    }
}
