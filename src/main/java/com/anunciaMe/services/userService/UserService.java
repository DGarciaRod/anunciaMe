package com.anunciaMe.services.userService;

import com.anunciaMe.entities.Usuario.Usuario;

public interface UserService {
    public Usuario findUserById(String id);
    public Usuario registerUser(String nombre, String userName, String contrasena);
    public Usuario login(String userName, String contrasena);
    public Usuario loginFromToken(String token);
    public String generateTokenForUser(Usuario user);

    public Integer getVentasUsuario(Usuario user);
    public Integer getComprasUsuario(Usuario user);
    public Float getCalificacionMedia(Usuario user);
    public Integer getNumReviewsRecibidas(Usuario user);
}
