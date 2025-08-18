package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("mediaType")
public class VersionsConfigQueryMediaTypeParam implements WebMvcConfigurer {

	@Override
	public void configureApiVersioning(ApiVersionConfigurer configurer) {
		//configurer.setDefaultVersion("1.0.0");
		configurer.useMediaTypeParameter(MediaType.APPLICATION_JSON, "version_mt_param");
	}

	/*@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.addPathPrefix("/api", HandlerTypePredicate.forAnnotation(RestController.class));
	}*/
}