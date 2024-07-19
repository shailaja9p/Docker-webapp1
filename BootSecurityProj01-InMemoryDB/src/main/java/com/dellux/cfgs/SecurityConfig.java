package com.dellux.cfgs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles(
		 * "CUSTOMER").accountLocked(true);
		 * auth.inMemoryAuthentication().withUser("suresh").password("{noop}hyd").roles(
		 * "EMPLOYEE");
		 * auth.inMemoryAuthentication().withUser("rajesh").password("{noop}vizag").
		 * roles("VISITOR");
		 * auth.inMemoryAuthentication().withUser("anil").password("{noop}delhi").roles(
		 * "CUSTOMER","EMPLOYEE");
		 */
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$YQaPy7XE79itcMc0I30Fdux6M4E06pDSSnR/f9ImRX/7d9JGXyzzG").roles("CUSTOMER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("suresh").password("$2a$10$x9BjD.ZFUCQpzPLAbi25HOGJkmOr8mWkEe3MUkbr7amo60Sxfs1wu").roles("EMPLOYEE");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("rajesh").password("$2a$10$VzMgjZdWDcIpvI/cYkAilOXd4wmlhWChP47WaIG0XU4KBORIrNPfO").roles("VISITOR");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser(" ").password("$2a$10$fasBY987QdFgV6dctlE62.2NsyQlpkHOwHp/MNYnM8uWIoZZ9IaU6").roles("CUSTOMER","EMPLOYEE");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/offers").hasAnyRole("CUSTOMER","EMPLOYEE","VISITOR")
		.antMatchers("/balance").hasAnyRole("CUSTOMER","EMPLOYEE")
		.antMatchers("/approve").hasRole("EMPLOYEE")
		.anyRequest().authenticated()
		
		//.and().httpBasic()
		.and().formLogin()
		
		.and().rememberMe()
		//.and().logout()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		
		.and().exceptionHandling().accessDeniedPage("/denied");
	}
}
