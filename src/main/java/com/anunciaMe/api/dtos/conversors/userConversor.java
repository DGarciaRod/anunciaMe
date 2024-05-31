package com.anunciaMe.api.dtos.conversors;

import com.anunciaMe.api.dtos.UserDto;
import com.anunciaMe.entities.Usuario.Usuario;

public class userConversor {
    public static UserDto userToDto(Usuario user){
        return new UserDto(user.getId(), user.getNombre(), user.getUsuario());
    }
}
