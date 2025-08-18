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
		// if set, fails with `versionRequired cannot be set to true if a defaultVersion is also configured`
		//configurer.setDefaultVersion("3.0.0");
		configurer.setVersionRequired(true);
		//configurer.setVersionRequired(false);
	}


}