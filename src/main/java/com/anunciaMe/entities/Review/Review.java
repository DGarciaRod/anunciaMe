package com.anunciaMe.entities.Review;

import com.anunciaMe.entities.Usuario.Usuario;
import com.anunciaMe.entities.Compra.Compra;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="reviews")
public class Review {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "compra")
    private Compra compra;
    @Column(name="calificacion")
    private Integer calificacion;

    @Column(name="mensaje")
    private String mensaje;

    @Transient
    private Usuario comprador;

    public Review() {
    }


    public Review(String id, Compra compra, Integer calificacion,
                  String mensaje, Usuario comprador) {
        this.id = id;
        this.compra = compra;
        this.calificacion = calificacion;
        this.mensaje = mensaje;
        this.comprador = comprador;
    }

    public Review(Compra compra, Integer calificacion, String mensaje) {
        this.compra = compra;
        this.calificacion = calificacion;
        this.mensaje = mensaje;
    }
    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, compra, calificacion, mensaje);
    }
}
