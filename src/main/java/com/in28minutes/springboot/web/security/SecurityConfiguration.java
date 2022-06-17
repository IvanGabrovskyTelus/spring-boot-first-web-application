package com.in28minutes.springboot.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	//Create Users - in28Minutes/dummy
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
		PasswordEncoder encoder = 
		          PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		    	auth
//		          .inMemoryAuthentication()
//		          .withUser("in28minutes")
//		          .password(encoder.encode("dummy"))
//		          .roles("USER", "ADMIN")
//		          .and()
//		          .withUser("in28Minutes")
//		          .password(encoder.encode("dummy"))
//		          .roles("USER", "ADMIN");
		auth.inMemoryAuthentication().withUser("in28Minutes").password("dummy")
				.roles("USER", "ADMIN");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().authorizeRequests().anyRequest().antMatchers("/login").permitAll()
//                .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
//                .authenticated().formLogin().httpBasic();
		http.authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll();
    }
	
	//Create a Login form
}
