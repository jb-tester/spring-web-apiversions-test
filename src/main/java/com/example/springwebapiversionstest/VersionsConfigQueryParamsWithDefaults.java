package com.example.springwebapiversionstest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("queryParamWithDefaults")
public class VersionsConfigQueryParamsWithDefaults implements WebMvcConfigurer {

	@Override
	public void configureApiVersioning(ApiVersionConfigurer configurer) {
		configurer.setDefaultVersion("1.0.0");
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