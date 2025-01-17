package com.chatapp.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
public class springSecurityConfigurer {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
	
	@Bean 
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		
		http
			.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/css/**" , "/resources/**").permitAll()
					.requestMatchers("/", "index").permitAll()
					.requestMatchers("sign-up-page").permitAll()
					.requestMatchers("/hello").authenticated()
					.anyRequest().authenticated()
					)
					.formLogin(formLogin -> formLogin
							.loginPage("/index").permitAll()
							.successHandler(myAuthenticationSuccessHandler)
							)
					.logout((logout) -> logout
							.permitAll()
							);
			return http.build();
	
	}
}
