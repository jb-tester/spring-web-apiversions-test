package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void configureApiVersioning(ApiVersionConfigurer configurer) {
		//configurer.setDefaultVersion("1.0.0");
		//configurer.useRequestHeader("Version-header");
		//configurer.useRequestParam("version_req_param"); // obsolete
		//configurer.useMediaTypeParameter(MediaType.APPLICATION_JSON, "version_mt_param");
		//configurer.usePathSegment(1);
		configurer.useQueryParam("version_query_param");
	}

	/*@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.addPathPrefix("/api", HandlerTypePredicate.forAnnotation(RestController.class));
	}*/
}