package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

//빈 등록 :스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration // IoC
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Bean //IoC가 됌. 
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {	
		
		 http
		 	.csrf().disable() // csrf 토큰 비활성화
		    .authorizeRequests()
		    	.requestMatchers("/**", "/auth/**", "/js/**", "/css/**", "/image/**")
		    	.permitAll()
		    	.anyRequest()
		    	.authenticated()
		 	.and()
		 		.formLogin()
		 		.loginPage("/auth/loginForm");
		  return http.build();
	}
}