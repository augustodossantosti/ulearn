package com.ulearn.ulearn.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Contém as configurações do Spring MVC.
 *
 * @author Augusto Santos
 * @version 1.0 16/09/18
 */
@EnableWebMvc
@Configuration
public class ConfiguracaoSpringMvc implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
                .allowedHeaders("*");
    };
}
