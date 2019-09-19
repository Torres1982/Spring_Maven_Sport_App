package com.torres.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import com.torres.util.Constants;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()			
			.antMatchers("/main/showRegistrationForm/**").hasAnyRole(Constants.UserRoles.ROLE_MANAGER, Constants.UserRoles.ROLE_ADMIN)
			.antMatchers("/main/showRegistrationFormToUpdate/**").hasAnyRole(Constants.UserRoles.ROLE_MANAGER, Constants.UserRoles.ROLE_ADMIN)
			.antMatchers("/main/deletePlayer").hasRole(Constants.UserRoles.ROLE_ADMIN)
			.antMatchers("/register/showAppUserRegistrationForm/**").hasRole(Constants.UserRoles.ROLE_ADMIN)
			.antMatchers("/").permitAll()
			.and()
			.formLogin()
				.loginPage("/showLoginPage")
				.loginProcessingUrl("/authenticateUser")
				.defaultSuccessUrl("/main/home", true)
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/")
				.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/resources/**");
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		
		return jdbcUserDetailsManager; 
	}
}