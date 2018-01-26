package com.aiqifi.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebSecurity;

/**
 * Security configuration.
 *
 * @author Ryan.W
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("secret").roles("SUPERUSER");
		// .and()
		// .withUser("user2").password("secret2").roles("USER");
	}

	/**
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	/*	
	 http.authorizeRequests().anyRequest().fullyAuthenticated();
	 http.httpBasic();
	 http.csrf().disable();
	*/
		 http
         .authorizeRequests()
             .antMatchers("/", "/home").permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
             .and()
         .logout()
             .permitAll();
	}
		
}