//SecurityConfig.java
package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity	//this makes the normal @Configuration Class as the SecurityConfiguration Class
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// builds authentication manager by taking authentication info provider i.e. InMemoryDB
		auth.inMemoryAuthentication().withUser("Akash").password("{noop}pune").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("Ram").password("{noop}delhi").roles("MANAGER");
		
	}//method
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// authorize requests
		http.authorizeRequests().antMatchers("/").permitAll()
													.antMatchers("/offers").authenticated()
													.antMatchers("/balance").hasAnyRole("CUSTOMER", "MANAGER")
													.antMatchers("/loan_approve").hasRole("MANAGER")
													.anyRequest().authenticated()
													.and().rememberMe()
												//.and().httpBasic()
													.and().formLogin()
													.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
													.and().exceptionHandling().accessDeniedPage("/denied");
	}//method
	

}//class
