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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
//		auth.inMemoryAuthentication()
//			.withUser("artur").password(passwordEncoder().encode("artur")).roles("EMPLOYEE")
//			.and()
//			.withUser("michal").password(passwordEncoder().encode("michal")).roles("EMPLOYEE", "MANAGER")
//			.and()
//			.withUser("paul").password(passwordEncoder().encode("paul")).roles("EMPLOYEE", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.anyRequest().authenticated()
			.antMatchers("/").permitAll()
			.antMatchers("/main/showRegistrationForm/**").hasAnyRole("ADMIN", "MANAGER")
			.antMatchers("/main/showRegistrationFormToUpdate/**").hasAnyRole("ADMIN", "MANAGER")
			.antMatchers("/main/deletePlayer/**").hasAnyRole("ADMIN", "MANAGER")
			.and()
			.formLogin()
				.loginPage("/showLoginPage")
				.loginProcessingUrl("/authenticateUser")
				.defaultSuccessUrl("/main/home", true)
				.permitAll()
			.and()
			.logout()
				//.logoutSuccessUrl("/")
				.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/resources/**");
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}