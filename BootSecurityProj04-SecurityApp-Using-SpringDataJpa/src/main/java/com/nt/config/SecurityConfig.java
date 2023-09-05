//SecurityConfig.java
package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.nt.service.IUserService;

@Configuration
@EnableWebSecurity	//this makes the normal @Configuration Class as the SecurityConfiguration Class
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private IUserService service;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}//method
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// authorize requests
		http.authorizeRequests().antMatchers("/","/bank/","/user/register","/user/showLogin").permitAll()
													.antMatchers("/bank/offers").authenticated()
													.antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER", "MANAGER")
													.antMatchers("/bank/loan_approve").hasAuthority("MANAGER")
													.anyRequest().authenticated()
													.and().rememberMe()
												//.and().httpBasic()
													.and().formLogin().defaultSuccessUrl("/bank/",true).loginPage("/user/showLogin").loginProcessingUrl("/login")
													.failureUrl("/user/showLogin?error")
													.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
													.logoutSuccessUrl("/user/showLogin?logout")
													.and().exceptionHandling().accessDeniedPage("/denied");
	}//method
	

}//class
