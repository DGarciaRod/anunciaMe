package com.anunciaMe.api.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CompraDto {
    private String id;

    private String anuncio;

    private Integer cantidad;

    private String comprador;

    private BigDecimal precioPagadoPorArticulo;

    private LocalDateTime fecha;

    public interface CreateValidations {}
    public CompraDto(String anuncio, String comprador, Integer cantidad, BigDecimal precioPagadoPorArticulo, LocalDateTime fecha) {
        this.anuncio = anuncio;
        this.cantidad = cantidad;
        this.comprador = comprador;
        this.precioPagadoPorArticulo = precioPagadoPorArticulo;
        this.fecha=fecha;
    }

    public CompraDto(String id, String anuncio, String comprador, Integer cantidad, BigDecimal precioPagadoPorArticulo, LocalDateTime fecha) {
        this.id = id;
        this.anuncio = anuncio;
        this.cantidad = cantidad;
        this.comprador = comprador;
        this.precioPagadoPorArticulo = precioPagadoPorArticulo;
        this.fecha=fecha;
    }

    public CompraDto() {
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(String anuncio) {
        this.anuncio = anuncio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public BigDecimal getPrecioPagadoPorArticulo() {
        return precioPagadoPorArticulo;
    }

    public void setPrecioPagadoPorArticulo(BigDecimal precioPagadoPorArticulo) {
        this.precioPagadoPorArticulo = precioPagadoPorArticulo;
    }
}
