package com.cgi.todo_skeleton.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${project.description}")
    private String projectDescription;

    @Bean
    public OpenAPI apiDocket() {
        return new OpenAPI()
                .info(
                        new Info().title("ToDo List App")
                                .description(projectDescription)
                                .version("0.0.1")
                );
    }


}

