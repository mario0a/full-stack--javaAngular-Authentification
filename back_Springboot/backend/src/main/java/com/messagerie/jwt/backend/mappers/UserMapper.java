package com.messagerie.jwt.backend.mappers;


//avant de continuer avec le service ,jai besoin d'un mappeur avec Mapstruct pour mapper l'entité utilisateur à l'utilisateur DTO

import com.messagerie.jwt.backend.dto.UserDto;
import com.messagerie.jwt.backend.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //ce est tres important pour eviter de stoker des mots de passe en claire dans mon application

    UserDto userDto(User user);

}
