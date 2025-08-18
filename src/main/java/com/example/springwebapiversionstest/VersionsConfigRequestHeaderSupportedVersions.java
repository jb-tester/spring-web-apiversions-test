package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("requestHeaderSupportedVersions")
public class VersionsConfigRequestHeaderSupportedVersions implements WebMvcConfigurer {

	@Override
	public void configureApiVersioning(ApiVersionConfigurer configurer) {
		//configurer.setDefaultVersion("1.0.0");
		configurer.useRequestHeader("Version-header");
		//configurer.addSupportedVersions("1.2.0", "1.3.0", "2.0+"); // invalid format
		configurer.addSupportedVersions("1.2.0",  "1.4.0", "1.5.0", "2");
		// note that the supported versions will be used only with the following option set to false:
		configurer.detectSupportedVersions(false);
	}


}