package pak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

// http://localhost:8080/swagger-ui.html
// http://localhost:8080/swagger-resources/
// http://localhost:8080/v2/api-docs?group=greeting

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket greetingDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greeting")
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("pak.controllers"))
                //.paths(PathSelectors.any())
                //.paths(regex("/mc.*"))
                .paths(regex("/mcg/greeting"))
                .build()
                //.apiInfo(metaData())
                ;
    }


    private ApiInfo metaData() {
        return new ApiInfo(
                "Spring Boot REST API",
                "Spring Boot REST API for Online Store",
                "1.0",
                "Terms of service",
                new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0"
        );
    }

}
