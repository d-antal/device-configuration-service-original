package com.vodafone.device.configuration.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.vodafone.device.configuration.exception.ApiResponseErrorHandler;

import lombok.Generated;

@Generated
@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.errorHandler(new ApiResponseErrorHandler()).build();
	}

}
