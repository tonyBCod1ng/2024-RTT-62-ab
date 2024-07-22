package com.example.springBoot.validation;

import com.example.springBoot.database.entity.Employee;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailUniqueCheckImpl.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUniqueCheck {
    String message() default "{EmailUniqueCheck}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
