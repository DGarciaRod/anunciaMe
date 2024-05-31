package com.anunciaMe.services.userService;

import com.anunciaMe.entities.Usuario.Usuario;

public interface JwtService {
    public String generateToken(Usuario user);
    public JwtPayload validateToken(String token);
}
