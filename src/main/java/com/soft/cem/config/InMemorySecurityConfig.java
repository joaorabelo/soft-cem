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
			.withUser("admin").password("123456").roles("USER")
			.and()
			.withUser("n").password("123456").roles("USER")
			.and()
			.withUser("r").password("123456").roles("USER");
	}
}
