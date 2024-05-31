package com.anunciaMe.api.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;

public class CategoriaDto {
    private String id;
    private String nombre;

    public interface RegisterValidations {}

    public interface LoginValidations {}
    public interface GetValidations {}

    public CategoriaDto() {
    }

    public CategoriaDto(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @NotEmpty(groups = UserDto.RegisterValidations.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
