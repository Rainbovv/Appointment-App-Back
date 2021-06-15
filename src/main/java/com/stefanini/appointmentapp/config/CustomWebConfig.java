package com.stefanini.appointmentapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class CustomWebConfig extends WebMvcAutoConfiguration implements WebMvcConfigurer {

	@Value("${cors.allowed.origins}")
	String allowedOrigins;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET", "PUT", "POST", "DELETE")
				.allowedOrigins(allowedOrigins)
				.exposedHeaders("Authorization")
				.allowedHeaders("*");
		
	}
}
