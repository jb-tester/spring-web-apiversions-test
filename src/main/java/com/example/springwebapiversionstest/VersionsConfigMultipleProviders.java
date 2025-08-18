package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("multiple")
public class VersionsConfigMultipleProviders implements WebMvcConfigurer {

	@Override
	public void configureApiVersioning(ApiVersionConfigurer configurer) {
		//configurer.setDefaultVersion("1.0.0");
		configurer.useRequestHeader("Version-header-one");
		configurer.useRequestHeader("Version-header-two");
		configurer.useMediaTypeParameter(MediaType.APPLICATION_JSON, "version_mt_param_one");
		configurer.useMediaTypeParameter(MediaType.APPLICATION_JSON, "version_mt_param_two");
		//configurer.usePathSegment(1);
		configurer.useQueryParam("version_query_param_one");
		configurer.useQueryParam("version_query_param_two");
	}

	/*@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.addPathPrefix("/api", HandlerTypePredicate.forAnnotation(RestController.class));
	}*/
}