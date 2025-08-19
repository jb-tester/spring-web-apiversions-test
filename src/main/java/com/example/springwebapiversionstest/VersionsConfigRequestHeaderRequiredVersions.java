package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("requestHeaderRequiredVersions")
public class VersionsConfigRequestHeaderRequiredVersions implements WebMvcConfigurer {

	@Override
	public void configureApiVersioning(ApiVersionConfigurer configurer) {
		configurer.useRequestHeader("Version-header-required");
		// no idea how it works, i see no difference between true and false here
		configurer.setVersionRequired(true);
	}


}