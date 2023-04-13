package com.example.interviewtask.infrastructure.config.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "Authorization";
        final String apiTitle = String.format("%s API",
                StringUtils.capitalize("Spring boot JWT auth"));
        return new OpenAPI().addSecurityItem(
                        new SecurityRequirement().addList(securitySchemeName))
                .components(new Components().addSecuritySchemes("Authorization",
                        new SecurityScheme().scheme(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .in(SecurityScheme.In.HEADER)
                                .bearerFormat("Bearer ")))
                .info(new Info().title(apiTitle)
                        .version("V1"));
    }
}