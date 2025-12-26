package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

@Bean
public OpenAPI openAPI() {

final String securitySchemeName = "bearerAuth";

return new OpenAPI()
.info(new Info()
.title("Multi-Branch Academic Calendar Harmonizer")
.description("Centralized system for harmonizing academic calendars across branches")
.version("1.0.0")
)
.addServersItem(
new Server()
.url("https://9166.408procr.amypo.ai/")
.description("Production Server")
)
.addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
.components(
new io.swagger.v3.oas.models.Components()
.addSecuritySchemes(securitySchemeName,
new SecurityScheme()
.name(securitySchemeName)
.type(SecurityScheme.Type.HTTP)
.scheme("bearer")
.bearerFormat("JWT")
)
);
}
}
