//SecurityConfig.java
package com.nt.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity	//this makes the normal @Configuration Class as the SecurityConfiguration Class
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource ds;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// builds authentication manager by taking authentication info provider i.e. Oracle database
		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
			.usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?") // for Authentication
			.authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USER_ROLES WHERE UNAME=?");	// for Authorization
		
		
	}//method
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// authorize requests
		http.authorizeRequests().antMatchers("/").permitAll()
													.antMatchers("/offers").authenticated()
													.antMatchers("/balance").hasAnyAuthority("CUSTOMER", "MANAGER")
													.antMatchers("/loan_approve").hasAuthority("MANAGER")
													.anyRequest().authenticated()
													.and().rememberMe()
												//.and().httpBasic()
													.and().formLogin()
													.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
													.and().exceptionHandling().accessDeniedPage("/denied")
													.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		
	}//method
	

}//class
