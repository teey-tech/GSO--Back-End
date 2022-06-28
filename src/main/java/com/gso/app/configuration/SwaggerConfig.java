package com.gso.app.configuration;

import org.springframework.context.annotation.Configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI springBlogPessoalOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("GSO")
            .description("GSO - Thiago Batista")
            .version("v0.0.1")
            .license(new License()
                .name("Thiago Batista")
                .url("<https://github.com/teey-tech/>"))
            .contact(new Contact()
                .name("Github - Thiago")
                .url("<https://github.com/teey-tech/>")))
        .externalDocs(new ExternalDocumentation()
            .description("Github - Projeto")
            .url("<https://github.com/teey-tech/GSO--Back-End>"));
  }

  @Bean
  public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {

    return openApi -> {
      openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

        ApiResponses apiResponses = operation.getResponses();

        apiResponses.addApiResponse("200", createApiResponse("Success!"));
        apiResponses.addApiResponse("201", createApiResponse("Created whit Success!"));
        apiResponses.addApiResponse("204", createApiResponse("Error: Don't have nothing!"));
        apiResponses.addApiResponse("400", createApiResponse("Requisition Error!"));
        apiResponses.addApiResponse("401", createApiResponse("Unauthorized Access!"));
        apiResponses.addApiResponse("404", createApiResponse("Don't find anything!"));
        apiResponses.addApiResponse("500", createApiResponse("Aplication Error!"));

      }));
    };
  }

  private ApiResponse createApiResponse(String message) {

    return new ApiResponse().description(message);

  }
}
