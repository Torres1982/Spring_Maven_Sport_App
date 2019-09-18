package com.torres.util;

public class Constants {
	public interface Validation {
		public final static String ERROR_FOOTBALLER_REGISTRATION_FORM_LENGTH = "At Least 2 Characters Required";
		public final static String ERROR_FOOTBALLER_REGISTRATION_FORM_NULL = "Cannot Be Null";
	}
	
	public interface AppUserValidation {
		public final static String ERROR_APP_USER_REGISTRATION_FORM_LENGTH = "At Least 4 Characters Required";
	}
	
	public interface UserRoles {
		public final static String ROLE_ADMIN = "ADMIN";
		public final static String ROLE_MANAGER = "MANAGER";
		public final static String ROLE_USER = "USER";
	}
}
