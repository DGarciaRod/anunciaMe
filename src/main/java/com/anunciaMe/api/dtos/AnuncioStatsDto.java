package com.anunciaMe.api.dtos;

public class AnuncioStatsDto {
    String id;
    Float calificacionMedia;
    Integer numCompras;
    Integer numReviews;


    public AnuncioStatsDto() {
    }

    public AnuncioStatsDto(String id, Float calificacionMedia, Integer numCompras, Integer numReviews) {
        this.id = id;
        this.calificacionMedia = calificacionMedia;
        this.numCompras = numCompras;
        this.numReviews = numReviews;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getCalificacionMedia() {
        return calificacionMedia;
    }

    public void setCalificacionMedia(Float calificacionMedia) {
        this.calificacionMedia = calificacionMedia;
    }

    public Integer getNumCompras() {
        return numCompras;
    }

    public void setNumCompras(Integer numCompras) {
        this.numCompras = numCompras;
    }

    public Integer getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }
}
