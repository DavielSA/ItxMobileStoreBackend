package com.itxmobilestore.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        OpenAPI openAPi = new OpenAPI()
                .info(new Info().title("ITX Mobile Store")
                        .version("v0.1")
                        .contact(new Contact()
                                .name("Daviel")
                                .email("daviel.sanchez@gmail.com")
                                .url("https://itxmobilestore.com/")));
        return openAPi;
    }

}
