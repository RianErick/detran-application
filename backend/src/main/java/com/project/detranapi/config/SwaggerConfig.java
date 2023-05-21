package com.project.detranapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition

public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI (){

        return new OpenAPI()
                .info(info()
                        .contact(contact()));

    }

    public Info info (){
         return new Info()
                 .title("Detran Api")
                 .description("Api Destinada Para Estududos")
                 .version("1.0");

    }

    public Contact contact(){
        return  new Contact()
                .email("rianzx34@gmail.com")
                .name("Rian Erick");

    }

}

