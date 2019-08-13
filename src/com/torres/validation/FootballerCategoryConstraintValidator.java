package com.torres.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FootballerCategoryConstraintValidator implements ConstraintValidator<FootballerCategory, String> {
	private String categoryPrefix;
	
	@Override
	public void initialize(FootballerCategory footballerCategory) {
		categoryPrefix = footballerCategory.value();
	}
	
	@Override
	public boolean isValid(String category, ConstraintValidatorContext constraintValidatorContext) {
		boolean result;
		
		if (category != null) {
			 result = category.startsWith(categoryPrefix);
		} else {
			result = true;
		}
		return result;
	}

}
