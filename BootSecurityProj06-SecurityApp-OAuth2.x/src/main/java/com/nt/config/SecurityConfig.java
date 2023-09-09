//SecurityConfig.java
package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/","/home","/login").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.and().oauth2Login()	// custom login form development having hyperling to login as FB and Gmail user
		.and().csrf().disable();		//optional to implement
	}//method
	
}//class
