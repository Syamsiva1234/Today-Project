package com.example.Bankmangement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig{
	
	
	private UserDetailsService userDetailsService;
	
	public SecurityConfig(UserDetailsService userDetailsService){
		this.userDetailsService=userDetailsService;
	}
	
	@Bean
   public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
		return configuration.getAuthenticationManager();
	}



	  @Bean
	     SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeHttpRequests((authz) -> authz
//	            		.antMatchers("/api/auth/**").permitAll()
//	            		.antMatchers("/error").permitAll()
	            		.antMatchers("/v2/api-docs","/swagger-ui/**","/api/auth/**","/error", "/swagger-resources/**", "/*/swagger-resources/**",
	                          "/*/v2/api-docs")
	            		 .permitAll()
	                .anyRequest().authenticated()
	            );
	        return http.build();
	    }
}

