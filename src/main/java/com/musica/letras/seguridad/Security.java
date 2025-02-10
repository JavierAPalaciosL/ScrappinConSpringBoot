package com.musica.letras.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(httpSecurityCsrfConfigurer ->
        {
            httpSecurityCsrfConfigurer.disable();
        }).authorizeHttpRequests(authorizeRequests ->{
            authorizeRequests.requestMatchers("/users/login").permitAll()
                    .requestMatchers("/users/register").permitAll()
                    .requestMatchers("/users/conflcteo").permitAll()
                        .anyRequest().authenticated();
            //EDITANDO EL MISMO ARCHIVO PARA VER SI EXISTEN CONFLICTOS

        })
                .build();
    }

}
