package com.desafio.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("API de Clientes - Empresa de Vendas Online")
                    .description("API REST para cadastro e consulta de clientes, com integração a empresas parceiras de logística, marketing e outros serviços.")
                    .version("1.0.0")
                    .contact(new Contact()
                        .name("Equipe de Desenvolvimento")
                        .email("suporte@empresaonline.com")
                        .url("https://empresaonline.com"))
                    .license(new License()
                        .name("Licença Proprietária")
                        .url("https://empresaonline.com/licenca"))
                );
    }
}
