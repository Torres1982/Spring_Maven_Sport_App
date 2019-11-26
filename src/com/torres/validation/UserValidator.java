package com.torres.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
//import java.lang.String;
import com.torres.model.AppUser;

@Component
public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> appUserClass) {
		return AppUser.class.equals(appUserClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AppUser appUser = (AppUser) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "appUser.userName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "appUser.password.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userRole", "appUser.userRole.empty");
		
		if (appUser.getUserName().length() < 2) {
			errors.rejectValue("userName", "User Name has to be Longer than 1 Character!");
		}
		
		if (appUser.getPassword().length() < 4) {
			errors.rejectValue("password", "Password has to be Longer than 3 Characters!");
		}
		
		if (appUser.getUserRole() == null) {
			errors.rejectValue("userRole", "User Role Has to be Selected!");
		}
	}
}
