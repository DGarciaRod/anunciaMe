package com.anunciaMe.api;

import com.anunciaMe.api.dtos.UserDto;
import com.anunciaMe.api.dtos.UserStatsDto;
import com.anunciaMe.api.dtos.conversors.userConversor;
import com.anunciaMe.entities.Usuario.Usuario;
import com.anunciaMe.services.errors.InvalidLoginError;
import com.anunciaMe.services.errors.InvalidTokenError;
import com.anunciaMe.services.errors.UserNotFoundError;
import com.anunciaMe.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/usuarios", produces = "application/json;charset=utf-8")
public class UsuarioController {


    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findStateById(@PathVariable String id) {
        try {
            Usuario usuario = userService.findUserById(id);
            if(usuario==null)
                throw new UserNotFoundError();
            UserDto dto = userConversor.userToDto(usuario);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/../{id}").buildAndExpand(usuario.getId()).normalize()
                    .toUri();
            return ResponseEntity.created(location).body(dto);
        } catch (Exception e) {
            throw e;
        }
    }


    @PostMapping("/register")
    public ResponseEntity<UserDto> register(
            @Validated({UserDto.RegisterValidations.class}) @RequestBody UserDto userDto) throws Exception {
        try {
            Usuario usuario = userService.registerUser(userDto.getNombre(), userDto.getUsuario(), userDto.getPass());
            UserDto dto = userConversor.userToDto(usuario);
            dto.setToken(userService.generateTokenForUser(usuario));
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/../{id}").buildAndExpand(usuario.getId()).normalize()
                    .toUri();
            return ResponseEntity.created(location).body(dto);
        } catch (Exception e) {
            throw e;
        }

    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(
            @Validated({UserDto.LoginValidations.class}) @RequestBody UserDto userDto) {
        try {
            Usuario usuario = userService.login(userDto.getUsuario(), userDto.getPass());
            UserDto dto = userConversor.userToDto(usuario);
            dto.setToken(userService.generateTokenForUser(usuario));
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/../{id}").buildAndExpand(usuario.getId()).normalize()
                    .toUri();
            return ResponseEntity.created(location).body(dto);
        } catch (Exception e) {
            throw new InvalidLoginError();
        }


    }

    @PostMapping("/loginFromToken")
    public ResponseEntity<UserDto> loginFromToken(
            @Validated({UserDto.LoginFromTokenValidations.class}) @RequestBody UserDto userDto) {
        try {
            Usuario usuario = userService.loginFromToken(userDto.getToken());
            UserDto dto = userConversor.userToDto(usuario);
            dto.setToken(userDto.getToken());
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/../{id}").buildAndExpand(usuario.getId()).normalize()
                    .toUri();
            return ResponseEntity.created(location).body(dto);
        } catch (Exception e) {
            throw new InvalidTokenError();
        }
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<UserStatsDto> getStats(@PathVariable String id) {
        try {
            Usuario usuario = userService.findUserById(id);
            if(usuario==null)
                throw new UserNotFoundError();
            UserStatsDto dto = new UserStatsDto(
                    usuario.getId(),
                    userService.getVentasUsuario(usuario),
                    userService.getComprasUsuario(usuario),
                    userService.getCalificacionMedia(usuario),
                    userService.getNumReviewsRecibidas(usuario));
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/../{id}").buildAndExpand(usuario.getId()).normalize()
                    .toUri();
            return ResponseEntity.created(location).body(dto);
        } catch (Exception e) {
            throw e;
        }
    }
}
