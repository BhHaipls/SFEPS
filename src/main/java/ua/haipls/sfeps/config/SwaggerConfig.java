package ua.haipls.sfeps.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static ua.haipls.sfeps.config.MessageConfig.REQUEST_PARAM_LANGUAGE_NAME;
import static ua.haipls.sfeps.config.SecurityConfig.HEADER_NAME;


@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ua.haipls.sfeps.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())
                .securitySchemes(Lists.newArrayList(apiKey()))
                .securityContexts(Lists.newArrayList(securityContext()))
                .globalOperationParameters(Lists.newArrayList(language()));
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", HEADER_NAME, "header");
    }

    private Parameter language() {
        return new ParameterBuilder()
                .name(REQUEST_PARAM_LANGUAGE_NAME)
                .description("Language")
                .modelRef(new ModelRef("string"))
                .parameterType("query")
                .required(true)
                .allowableValues(new AllowableListValues(Lists.newArrayList("en", "uk"), "string"))
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API")
                .description("\"Spring Boot REST API for SFEP&S (service for event processing and statistics)\"")
                .version("1.0.0")
                .license("GNU Lesser General Public License v3.0")
                .licenseUrl("https://www.gnu.org/licenses/lgpl-3.0.html")
                .contact(new Contact("Bohdan Hrytsak", "https://sfeps.ua/contact", "bh.haipls@gmail.com"))
                .build();
    }

}
