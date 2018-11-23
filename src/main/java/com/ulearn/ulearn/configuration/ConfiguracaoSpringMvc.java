package com.ulearn.ulearn.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Contém as configurações do Spring MVC.
 *
 * @author Augusto Santos
 * @version 1.0 16/09/18
 */
@Configuration
public class ConfiguracaoSpringMvc implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*").allowedHeaders("*");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/meus-cursos").setViewName("cursos.html");
        registry.addViewController("/curso-descricao").setViewName("curso-descricao.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
