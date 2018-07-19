package org.thepoet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 18.07.2018
 */
@Configuration
@EnableSwagger2
public class TakeawaySwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket employeeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.thepoet"))
                .paths(PathSelectors.regex("/api/.*"))
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("takeaway.com Employee API")//
                .description("This small API is built for takeaway.com's task challenge. It provides creating, updating, deleting and listing employee API calls.")//
                .contact(new Contact("Oguzhan 'the Poet' Dogan", "https://github.com/ogzhndgn", "dogan_oguzhan@hotmail.com"))//
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}