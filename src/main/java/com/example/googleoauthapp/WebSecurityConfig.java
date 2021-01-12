package com.example.googleoauthapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
				authorizeRequests()
					.antMatchers("/", "/home", "/images**").permitAll()
					.anyRequest().authenticated()
					.and()
				.oauth2Login()
					.loginPage("/login")
					.permitAll()
					.and()
				.logout()
					.permitAll();
	}
}
