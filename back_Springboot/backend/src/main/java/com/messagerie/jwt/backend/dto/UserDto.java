package com.messagerie.jwt.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // pour les bd
@AllArgsConstructor
@NoArgsConstructor
@Builder

//creation des entités

// on utilise cette classe pour que les informations d'identification DTO sont juste pour la reception
public class UserDto {

    private Long id;
    private String nom;
    private String prenom;
    private String login;
    private String token;
}
