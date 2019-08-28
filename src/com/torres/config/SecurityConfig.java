package com.torres.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("artur").password("{noop}artur").roles("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("michal").password("{noop}michal").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("paul").password("{noop}paul").roles("ADMIN");
	}	
	
}