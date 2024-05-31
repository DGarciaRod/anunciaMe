package com.anunciaMe.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class UserDto {

    private String id;
    private Integer tipo;
    private String nombre;
    private String usuario;
    private String pass;

    private String token;

    public interface RegisterValidations {}

    public interface LoginValidations {}
    public interface GetValidations {}

    public interface LoginFromTokenValidations {}
    public UserDto() {
    }



    public UserDto(String id, String nombre, String usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.id = id;
    }

    public UserDto(String id, Integer tipo, String nombre, String usuario) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.usuario = usuario;
    }
    public UserDto(String id, Integer tipo, String nombre, String usuario, String pass, String token) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.usuario = usuario;
        this.pass = pass;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotEmpty(groups = RegisterValidations.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @NotEmpty(groups = LoginValidations.class)
    @NotEmpty(groups = RegisterValidations.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    @Null(groups = GetValidations.class)
    @NotEmpty(groups = LoginValidations.class)
    @NotEmpty(groups = RegisterValidations.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @NotEmpty(groups = LoginFromTokenValidations.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
