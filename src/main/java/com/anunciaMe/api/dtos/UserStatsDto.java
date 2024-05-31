package com.anunciaMe.api.dtos;

import java.math.BigDecimal;

public class UserStatsDto {
    private String id;
    private Integer ventas;
    private Integer compras;

    private Integer reviews;
    private BigDecimal dineroCompras;
    private BigDecimal dineroVentas;

    private Float calificacionMedia;
    private Integer reviewsRecibidas;

    public UserStatsDto(String id, Integer ventas, Integer compras, Float calificacionMedia, Integer reviewsRecibidas) {
        this.id = id;
        this.ventas = ventas;
        this.compras = compras;
        this.calificacionMedia = calificacionMedia;
        this.reviewsRecibidas=reviewsRecibidas;
    }

    public UserStatsDto() {
    }

    public UserStatsDto(String id, Integer ventas, Integer compras, Integer reviews, BigDecimal dineroCompras, BigDecimal dineroVentas, Float calificacionMedia, Integer reviewsRecibidas) {
        this.id = id;
        this.ventas = ventas;
        this.compras = compras;
        this.reviews = reviews;
        this.dineroCompras = dineroCompras;
        this.dineroVentas = dineroVentas;
        this.calificacionMedia = calificacionMedia;
        this.reviewsRecibidas = reviewsRecibidas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVentas() {
        return ventas;
    }

    public void setVentas(Integer ventas) {
        this.ventas = ventas;
    }

    public Integer getCompras() {
        return compras;
    }

    public void setCompras(Integer compras) {
        this.compras = compras;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public BigDecimal getDineroCompras() {
        return dineroCompras;
    }

    public void setDineroCompras(BigDecimal dineroCompras) {
        this.dineroCompras = dineroCompras;
    }

    public BigDecimal getDineroVentas() {
        return dineroVentas;
    }

    public void setDineroVentas(BigDecimal dineroVentas) {
        this.dineroVentas = dineroVentas;
    }

    public Float getCalificacionMedia() {
        return calificacionMedia;
    }

    public void setCalificacionMedia(Float calificacionMedia) {
        this.calificacionMedia = calificacionMedia;
    }

    public Integer getReviewsRecibidas() {
        return reviewsRecibidas;
    }

    public void setReviewsRecibidas(Integer reviewsRecibidas) {
        this.reviewsRecibidas = reviewsRecibidas;
    }
}