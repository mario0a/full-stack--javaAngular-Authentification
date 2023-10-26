package com.messagerie.jwt.backend.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

@Configuration
@EnableWebMvc
public class WebConfig {
    //ceci permet à mon backend de recevoir les en-tetes contenant les inforrmations d'authentification
    @Bean
    public FilterRegistrationBean corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        //ceci est l'url de mon frontend
        config.addAllowedOrigin("http://localhost:4200/");
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.AUTHORIZATION,
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT// certain entete typique que mon application doit accepter
        ));
        //ici se trouve les methodes que mon backend doit accepter
config.setAllowedMethods(Arrays.asList(
        HttpMethod.GET.name(),
        HttpMethod.POST.name(),
        HttpMethod.PUT.name(),
        HttpMethod.DELETE.name()

));
//le temps que la configuration Cors est acceptée, 30minutes
        config.setMaxAge(3600L);
        // ici , on applique la configuration à toutes mes routes
        source.registerCorsConfiguration("/**",config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        //on place  le Bean à la position la plus basse pour qu'il soit exécuter avant tout spring bean.
        bean.setOrder(-102);
        return bean;
    }
}
