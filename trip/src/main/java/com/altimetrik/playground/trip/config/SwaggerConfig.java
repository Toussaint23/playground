package com.altimetrik.playground.trip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String LICENCE_TEXT = "Apache LICENCE";
    private static final String TITLE = "A REST API for getting Cheapest and fastest trip";
    private static final String DESCRIPTION = "REST API to find your best trip";
    private static final Contact CONTACT = new Contact("Jean Joseph Toussaint","http://www.altimetric.com","joseph.toussaint90@gmail.com");


    @Bean
    public Docket swaggerDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.altimetrik.playground.trip"))
                .paths(PathSelectors.regex("/api/trip.*"))
                .build()
                .apiInfo(metaInfo());

    }

    private ApiInfo metaInfo() {

        return new ApiInfo(TITLE,DESCRIPTION,SWAGGER_API_VERSION,"Terms of Service",CONTACT.toString(),LICENCE_TEXT,"https://www.apache.org/license");
    }
}
