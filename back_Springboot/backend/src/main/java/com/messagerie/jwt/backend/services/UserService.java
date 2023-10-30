package com.messagerie.jwt.backend.services;


// on cree notre service

import com.messagerie.jwt.backend.dto.CredentialsDto;
import com.messagerie.jwt.backend.dto.UserDto;
import com.messagerie.jwt.backend.entities.User;
import com.messagerie.jwt.backend.exceptions.AppException;
import com.messagerie.jwt.backend.exceptions.AppExcetion;
import com.messagerie.jwt.backend.mappers.UserMapper;
import com.messagerie.jwt.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
@RequiredArgsConstructor
public class UserService {

    //on rajoute toutes les dependances du repository.

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @SneakyThrows
    public UserDto login(CredentialsDto credentialsDto){
      User user =  userRepository.findByLogin(credentialsDto.login())
                // si on ne trouve pas , on leve une exeption
                .orElseThrow(()->new AppException("Utilisateur inconnu",HttpStatus.NOT_FOUND));

      //ensuite on commence par comparer le mot de passe donné avec le mot de passe dans la base de données.

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), ((User) user).getPassword())){

            // si c'est correct ,on passe l'utilisateur de la base de donnée à un utilisateur DTO.
            return  userMapper.userDto(user);
        }
        // sinon on retourne une exception
        throw new AppExcetion("le mot de passe est invalide !",HttpStatus.BAD_REQUEST);
    }
}
