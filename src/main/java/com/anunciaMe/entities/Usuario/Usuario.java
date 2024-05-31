package com.anunciaMe.entities.Usuario;

import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "usuarios")
@Entity
public class Usuario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nombreusuario")
    private String usuario;

    @Column(name = "passhash")
    private String passHash;

    public Usuario() {
    }

    public Usuario(String nombre, String usuario, String passHash) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.passHash = passHash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, usuario, passHash);
    }
}