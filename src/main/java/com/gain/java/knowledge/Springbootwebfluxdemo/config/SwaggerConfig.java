package com.gain.java.knowledge.Springbootwebfluxdemo.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
		title = "Springweb flux functional endpoint .",
		version = "1.0",
		description = "swagger documentation using open api."
		))
public class SwaggerConfig {

}
