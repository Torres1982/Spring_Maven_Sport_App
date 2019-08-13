package com.torres.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = FootballerCategoryConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FootballerCategory {
	public String value() default "FOOTBALL";
	public String message() default "Must Start with 'FOOTBALL'";
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}
