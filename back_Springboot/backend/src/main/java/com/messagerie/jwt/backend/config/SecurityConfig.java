package com.messagerie.jwt.backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity

public class SecurityConfig {

    @Bean
    //creation de la chaine de filtrage
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //pour simplifier ,on desactive le CSRF
        httpSecurity.csrf(AbstractHttpConfigurer::disable) //on indique qu'on est dans une application stateless
                .sessionManagement(customize ->customize.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((requests)->
                        requests.requestMatchers(HttpMethod.POST,"/login").permitAll()
                                .anyRequest().authenticated()
                );
        return httpSecurity.build();
    }
}
