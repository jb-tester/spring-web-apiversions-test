package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("requestHeader")
public class VersionsConfigRequestHeader implements WebMvcConfigurer {

	@Override
	public void configureApiVersioning(ApiVersionConfigurer configurer) {
		//configurer.setDefaultVersion("1.0.0");
		configurer.useRequestHeader("Version-header");
	}


}