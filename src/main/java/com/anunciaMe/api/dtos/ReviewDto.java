package com.anunciaMe.api.dtos;

public class ReviewDto {
    String id;
    String compra;
    Integer calificacion;
    String mensaje;

    String comprador;

    public ReviewDto() {
    }

    public ReviewDto(String id, String compra, Integer calificacion, String mensaje, String compradorId) {
        this.id = id;
        this.compra = compra;
        this.calificacion = calificacion;
        this.mensaje = mensaje;
        this.comprador = compradorId;
    }

    public ReviewDto(String compra, Integer calificacion, String mensaje) {
        this.compra = compra;
        this.calificacion = calificacion;
        this.mensaje = mensaje;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
