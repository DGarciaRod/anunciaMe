package com.anunciaMe.api.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AnuncioDto {
    private String id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String vendedor;
    private BigDecimal precio;
    private List<String> imagenes;
    private String categoriaId;
    private String vendedorId;

    private String calificacionMedia;


    public interface CreateValidations {}

    public AnuncioDto() {
    }

    public AnuncioDto(String id, String nombre, String descripcion, String categoria, String vendedor,
                      BigDecimal precio, List<String> imagenes, String categoriaId, String vendedorId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.vendedor = vendedor;
        this.precio = precio;
        this.imagenes = imagenes;
        this.categoriaId = categoriaId;
        this.vendedorId = vendedorId;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
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
