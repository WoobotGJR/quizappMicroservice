package com.woobot.apigateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi questionApi() {
        return GroupedOpenApi.builder()
                .group("question-service")
                .pathsToMatch("/question-service/question/**")
                .build();
    }

    @Bean
    public GroupedOpenApi quizApi() {
        return GroupedOpenApi.builder()
                .group("quiz-service")
                .pathsToMatch("/quiz-service/quiz/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Documentation")
                        .version("1.0")
                        .description("Documentation for your API")
                        .termsOfService("https://example.com/terms")
                        .contact(new Contact()
                                .name("Your Name")
                                .email("your-email@example.com")
                                .url("https://example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")));
    }
}
