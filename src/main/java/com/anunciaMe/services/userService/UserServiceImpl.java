package com.anunciaMe.services.userService;

import com.anunciaMe.entities.Usuario.Usuario;
import com.anunciaMe.entities.Usuario.UsuarioDao;
import com.anunciaMe.services.errors.InvalidLoginError;
import com.anunciaMe.services.errors.InvalidTokenError;
import com.anunciaMe.services.errors.UserAlreadyExistis;
import com.anunciaMe.services.errors.UserNotFoundError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsuarioDao usuarioDao;


    @Autowired
    private PasswordHashService passwordHashService;

    @Autowired
    private JwtService jwtService;

    public Usuario findUserById(String id) {
            Optional<Usuario> user = usuarioDao.findById(id);
            return user.orElse(null);


    }

    public Usuario registerUser(String nombre, String userName, String contrasena) {
        Boolean usrExists = usuarioDao.findByUsuario(userName).isPresent();
        if (usrExists)
            throw new UserAlreadyExistis();
        Usuario user = new Usuario(nombre, userName, contrasena);
        user.setPassHash(passwordHashService.PassToHash(contrasena));
        user=usuarioDao.save(user);
        return user;
    }

    public Usuario login(String userName, String contrasena){
        Optional<Usuario> userOpt = usuarioDao.findByUsuario(userName);
        if(userOpt.isEmpty())
            throw new UserNotFoundError();
        else{
            Usuario user = userOpt.get();
            if (passwordHashService.CompareHashToPass(user.getPassHash(), contrasena)) {
                return user;
            }else
                throw new InvalidLoginError();
        }
    }

    public Usuario loginFromToken(String token)  {
        JwtPayload payload = null;
        try {
            payload = jwtService.validateToken(token);

        } catch (Exception e) {
            throw new InvalidTokenError();
        }
        String userId = payload.getUserId();
        Optional<Usuario> usrOpt= usuarioDao.findById(userId);
        if(usrOpt.isEmpty())
            throw new UserNotFoundError();
        Usuario user = usrOpt.get();
        if (user.getId().equals(payload.getUserId())) {
            return user;
        }else
            throw new UserNotFoundError();
    }

    public String generateTokenForUser(Usuario user)  {
        return jwtService.generateToken(user);
    }

    public Integer getVentasUsuario(Usuario user){
        return usuarioDao.getNumVentas(user);
    }

    public Integer getComprasUsuario(Usuario user){
        return usuarioDao.getNumCompras(user);
    }


    public Float getCalificacionMedia(Usuario user) {
        return usuarioDao.getCalificacionMedia(user);
    }

    public Integer getNumReviewsRecibidas(Usuario user) {
        return usuarioDao.getNumReviewsRecibidas(user);
    }


}
