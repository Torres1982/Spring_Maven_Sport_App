package com.torres.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.torres.user.AppUser;

@Component
public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> appUserClass) {
		return AppUser.class.equals(appUserClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AppUser appUser = (AppUser) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
		
		if (appUser.getUserName().length() == 0) {
			errors.rejectValue("userName", "Username cannot be Empty!");
		}
	}
}
