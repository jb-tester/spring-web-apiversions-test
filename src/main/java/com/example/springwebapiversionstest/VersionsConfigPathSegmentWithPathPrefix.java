package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("pathSegmentWithPathPrefix")
public class VersionsConfigPathSegmentWithPathPrefix implements WebMvcConfigurer {

	@Override
	public void configureApiVersioning(ApiVersionConfigurer configurer) {
		//configurer.setDefaultVersion("1.0.0");
		configurer.usePathSegment(0);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {

		configurer.addPathPrefix("/{v}", HandlerTypePredicate.forAnnotation(RestController.class));
	}
}