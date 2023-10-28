package com.messagerie.jwt.backend.dto;


//creation des identification D'dentification DTO en tant que record.
//et l'utilisateur DTO en tant que POJO
// (Plain Old Java Object : sont couramment utilisés dans le développement Java pour modéliser des entités métier,
// des données de base de données, des objets de transfert de données (DTO) ou tout autre objet qui nécessite une structure de données simple.,
// un objet java ordinaire
public record CredentialsDto(String login, char[] password) {

}
