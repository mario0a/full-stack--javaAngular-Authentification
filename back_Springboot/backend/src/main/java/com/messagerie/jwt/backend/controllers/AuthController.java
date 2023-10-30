package com.messagerie.jwt.backend.controllers;


import com.messagerie.jwt.backend.dto.CredentialsDto;
import com.messagerie.jwt.backend.dto.UserDto;
import com.messagerie.jwt.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private  final UserService userService;// on cree notr service

    // le endpoint de connexion pour le front l'url pour se logger.
    //cette methode retournera un DtO et recevra comme json un autre dto
    @PostMapping("/login")
    public ResponseEntity<UserDto> login (@RequestBody CredentialsDto credentialsDto) {
        // à l'interieur on appelle un service avec une méthode de connexion.
        UserDto user = userService.login(credentialsDto);
        // on retourne directement l'utilisateur DTO
        return ResponseEntity.ok(user);
    }


}
