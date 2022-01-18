package com.lcode.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * This is the Configuration class that powered by both SpringBoot and SC
 * Microservice Framework.
 * 
 * @author Arunmugesh J
 *
 */
@Configuration
public class MyConfiguration implements WebMvcConfigurer {
	/**
	 * Configure cross origin requests processing.
	 * 
	 * @since 4.2
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedHeaders("*").allowedOrigins("*");
	}
}