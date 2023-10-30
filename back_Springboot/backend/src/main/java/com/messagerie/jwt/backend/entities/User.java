package com.messagerie.jwt.backend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//creation des champs qui seront present dans et mappés aux colonnes de la base de donnée.

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "app_user") // ici on nomme la table app_user car user est une table deja réservée par postgres.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false)
    private String nom;
    @Column(name = "last_name",nullable = false)
    private  String prenom;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private  String password;
    //on termine par la creation de la classe repository jpa
}
