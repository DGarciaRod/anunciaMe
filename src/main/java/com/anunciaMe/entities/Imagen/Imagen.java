package com.anunciaMe.entities.Imagen;

import com.anunciaMe.entities.Anuncio.Anuncio;
import jakarta.persistence.*;

@Entity
@Table(name="imagenes")
public class Imagen {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "anuncio")
    private Anuncio anuncio;

    @Lob
    @Column(name = "data", length = 16777215)
    private String data;

    public Imagen() {
    }

    public Imagen(Anuncio anuncio, String data) {
        this.anuncio = anuncio;
        this.data=data;
    }

    public Imagen(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
}
