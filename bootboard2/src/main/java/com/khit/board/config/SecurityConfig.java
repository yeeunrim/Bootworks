package com.khit.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomUserDetailService customService;
	
	@Bean // 스프링에서 관리하는 Bean이 아니므로 따로 선언 필요 (프로젝트에서 관리 안됨)
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		// 인증 설정 -> 권한 설정
		// 로그인X : "/", "/css/**", "/images/**", "/member/**", "/auth/main"
		// 로그인O : 그 외 경로
		http
			.authorizeHttpRequests(authorize -> authorize
					.requestMatchers("/", "/css/**", "/images/**", "/member/**", "/auth/main")
					.permitAll().anyRequest().authenticated())
					
			.formLogin(form -> form.loginPage("/member/login"));
		
		return http.build();
	}
	
	// 암호화 설정
	// PasswordEncoder를 상속받은 
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
