package com.ulearn.ulearn.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.http.HttpSession;

@EnableWebSecurity
public class ConfiguracaoSpringSecurity extends WebSecurityConfigurerAdapter {

    private final String[] allowedUrls = {"/", "/index.html", "/cursos/top", "/cursos", "/curso-descricao"};
    private final String[] resourcesUrls = {"/app/**", "/resources/**", "/favicon.ico"};

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("user1")).roles("USER", "ADMIN")
            .and()
                .withUser("user2").password(passwordEncoder().encode("user2")).roles("USER")
            .and()
                .withUser("user3").password(passwordEncoder().encode("user3")).roles("USER")
            .and()
                .withUser("user4").password(passwordEncoder().encode("user4")).roles("USER")
            .and()
                .withUser("user5").password(passwordEncoder().encode("user5")).roles("USER")
            .and()
                .withUser("user6").password(passwordEncoder().encode("user6")).roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(resourcesUrls).permitAll()
                .antMatchers(allowedUrls).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .failureHandler((req, resp, err) -> resp.setStatus(HttpStatus.UNAUTHORIZED.value()))
                .successHandler((req, resp, auth) -> {
                    final HttpSession session = req.getSession();
                    final SavedRequest savedRequest = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
                    if (savedRequest != null && savedRequest.getRedirectUrl() != null) {
                        resp.setHeader("REDIRECT_TO", savedRequest.getRedirectUrl());
                    } else {
                        resp.setHeader("REDIRECT_TO", "/");
                    }
                })
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
