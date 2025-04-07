package com.revisao.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
		@Bean //metodo para criptgrafar a senha do usuario
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		@Bean //desabilitando a segurança -> logar sem token
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	        http.csrf(csrf -> csrf.disable());
	        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
	        return http.build();
	    }
	}


