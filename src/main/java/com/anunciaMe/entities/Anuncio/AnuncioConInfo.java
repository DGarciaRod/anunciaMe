package com.anunciaMe.entities.Anuncio;

import com.anunciaMe.entities.Imagen.Imagen;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AnuncioConInfo {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String categoria;
    private String vendedor;

    private String categoriaId;
    private String vendedorId;
    @Transient
    private List<String> imagenes;

    public AnuncioConInfo() {
    }



    public AnuncioConInfo(String id, String nombre, String descripcion, BigDecimal precio, String categoria, String vendedor, String categoriaId, String vendedorId, List<Imagen> imagenes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.vendedor = vendedor;
        this.categoriaId = categoriaId;
        this.vendedorId = vendedorId;
        List<String> ls = new ArrayList<>();
        for (Imagen imagen : imagenes) {
            ls.add(imagen.getId());
        }
        this.imagenes = ls;
    }

    public AnuncioConInfo(String id, String nombre, String descripcion, BigDecimal precio, String categoria, String vendedor, String categoriaId, String vendedorId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.vendedor = vendedor;
        this.categoriaId = categoriaId;
        this.vendedorId = vendedorId;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(String vendedorId) {
        this.vendedorId = vendedorId;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
