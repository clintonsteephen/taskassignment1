package com.clinton.jobscheduling;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2




public class JobSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobSchedulingApplication.class, args);
	}
	
	@Bean
	public Docket productApi() {
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.basePackage("com.clinton.jobscheduling.controller"))
	/* .apis((Predicate<RequestHandler>) apiInfo())*/
	
	.paths(PathSelectors.any())
	.build();
	}
	
/*
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Información")
                .build();
    }*/
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("swagger-ui.html")
	        .addResourceLocations("classpath:/META-INF/resources/");

	registry.addResourceHandler("/webjars/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
