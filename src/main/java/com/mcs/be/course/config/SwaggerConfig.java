package com.mcs.be.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.any;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mcs.be.course.controller.rest"))
                .paths(any())
                .build().apiInfo(apiInfo())
                ;
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Backend Course API",
                "Article API",
                "API v1",
                "Terms of service",
                new Contact("Matteo Colombo Speroni", "", "matteo.colombo.work@gmail.com"),
                "MIT",
                "https://opensource.org/licenses/MIT",
                Collections.emptyList());
        return apiInfo;
    }
}

