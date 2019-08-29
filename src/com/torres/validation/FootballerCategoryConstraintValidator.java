//package com.torres.validation;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class FootballerCategoryConstraintValidator implements ConstraintValidator<FootballerCategory, String> {
//	private String [] categoryPrefix;
//	
//	@Override
//	public void initialize(FootballerCategory footballerCategory) {
//		categoryPrefix = footballerCategory.value();
//	}
//	
//	@Override
//	public boolean isValid(String category, ConstraintValidatorContext constraintValidatorContext) {
//		boolean result = false;
//		
//		if (category != null) {
//			for (String item : categoryPrefix) {
//				result = category.startsWith(item);
//				
//				if (result) {
//					break;
//				}
//			}
//		} else {
//			result = true;
//		}
//		return result;
//	}
//}
