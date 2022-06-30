package com.clinic.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * "http://localhost:8080/swagger-ui/" to see the documentation
 */
@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {

        ApiInfo apiInfo = new ApiInfo(
                "DEVELHOPE CLINIC",
                "a Clinic API",
                "1.0.0",
                "https://en.wikipedia.org/wiki/MIT_License",
                new Contact("JAVA 1 - Team 2", "", ""),
                "MIT",
                "https://en.wikipedia.org/wiki/MIT_License",
                Collections.emptyList()
        );

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo)
                .tags(
                        new Tag("appointment-controller", "Controller of the Appointments"),
                        new Tag("doctor-controller", "Controller of the Doctors"),
                        new Tag("patient-controller", "Controller of the Patients")
                );
    }

}
