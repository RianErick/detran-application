package com.project.detranapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InicialConfig {

    @Bean
   public CommandLineRunner commandLineRunner (){
       return args -> {
           System.out.println("Success");
       };
   }

}
