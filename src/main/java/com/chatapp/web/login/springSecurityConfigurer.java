package com.chatapp.web.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class springSecurityConfigurer {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
			@SuppressWarnings("deprecation")
			UserDetails user = 
					User.withDefaultPasswordEncoder()
						.username("optimus")
						.password("prime")
						.roles("USER")
						.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		
		http
			.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/" , "/home").permitAll()
					.anyRequest().authenticated()
					)
					.formLogin(formLogin -> formLogin
							.loginPage("/login")
							.permitAll()
							)
					.logout((logout) -> logout
							.permitAll()
							);
			return http.build();
	
	}
}
