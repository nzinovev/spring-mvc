package com.example.service.validation.annotation;

import com.example.service.validation.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConstraints {

    String message() default "Невалидный пароль";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
