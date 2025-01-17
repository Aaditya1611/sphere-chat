package com.chatapp.web.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class landingPageController implements WebMvcConfigurer {
	
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/sign-up-page").setViewName("sign-up-page");
	}
}
