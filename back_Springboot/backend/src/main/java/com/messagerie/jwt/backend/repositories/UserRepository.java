package com.messagerie.jwt.backend.repositories;


//creation de la classe repository jpa

import com.messagerie.jwt.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {

    // on cree une methode qui recherche un utilisateur par un login
    Optional<User> findByLogin(String login) ;

        //avant de continuer avec le service ,jai besoin d'un mappeur avec Mapstruct pour mapper l'entité utilisateur à l'utilisateur DTO



}
