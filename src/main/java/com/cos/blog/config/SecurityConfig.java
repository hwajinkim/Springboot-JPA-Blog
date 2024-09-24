package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

//빈 등록 :스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration // IoC
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {		
		 http
		    .authorizeRequests()
		    	.requestMatchers("/auth/**")
		    	.permitAll()
		    	.anyRequest()
		    	.authenticated()
		    .and()
		    	.formLogin()
		    	.loginPage("/auth/loginForm");
		 
		  return http.build();
 }
}