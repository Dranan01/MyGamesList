/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Francisco Miguel Pérez
 */
 @Configuration
public class myGamesListConfig {
     @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("MyGamesList API")
                        .description("Final project")
                        .contact(new Contact()
                                .name("Francisco Miguel Pérez Hurtado")
                                .email("franciscomiguelper.alumn@cescristorey.com"))
                        .version("0.1"));
    }

}
