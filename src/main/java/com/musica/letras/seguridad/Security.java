package com.musica.letras.seguridad;

import com.musica.letras.servicios.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {

    private CustomUserDetailsService userDetailsService;

    public Security(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    /*Cambiando el archivo de seguridad*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(httpSecurityCsrfConfigurer ->
        {
            httpSecurityCsrfConfigurer.disable();
        }).authorizeHttpRequests(authorizeRequests ->{
            authorizeRequests.requestMatchers("/users/register").permitAll()
                        .anyRequest().authenticated();
                })
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer.defaultSuccessUrl("/users/success", true);
                }).userDetailsService(userDetailsService)
                .build();
    }

    private String diAdios(){
        return "adios";
    }

    private String diHola(){
        return "Hola";
    }

    private String web(){
        System.out.println("la web");
        System.out.println("la de wb");

        return "web";
    }

}
