package com.soft.cem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;



@Configuration
public class InMemorySecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("admin").password("123").roles("USER")
			.and()
			.withUser("nelda").password("123").roles("USER")
			.and()
			.withUser("rabelo").password("123").roles("USER");
	}
}