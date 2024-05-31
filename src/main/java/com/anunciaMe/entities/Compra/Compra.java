package com.anunciaMe.entities.Compra;

import com.anunciaMe.entities.Anuncio.Anuncio;
import com.anunciaMe.entities.Usuario.Usuario;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="compras")
public class Compra {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "anuncio")
    private Anuncio anuncio;
    @Column(name = "cantidad")
    private Integer cantidad;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "comprador")
    private Usuario comprador;
    @Column(name = "preciopagadoporarticulo")
    private BigDecimal precioPagadoPorArticulo;

    @Column(name = "fecha")
    private LocalDateTime fecha;
    public Compra() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public Compra(Anuncio anuncio, Usuario comprador, Integer cantidad) {
        this.anuncio = anuncio;
        this.comprador = comprador;
        this.cantidad=cantidad;
        this.precioPagadoPorArticulo = anuncio.getPrecio();
        this.fecha=LocalDateTime.now();
    }

    public Compra(String id, Anuncio anuncio, Integer cantidad, Usuario comprador, BigDecimal precioPagadoPorArticulo, LocalDateTime fecha) {
        this.id = id;
        this.anuncio = anuncio;
        this.cantidad = cantidad;
        this.comprador = comprador;
        this.precioPagadoPorArticulo = precioPagadoPorArticulo;
        this.fecha = fecha;
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

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public BigDecimal getPrecioPagadoPorArticulo() {
        return precioPagadoPorArticulo;
    }

    public void setPrecioPagadoPorArticulo(BigDecimal precioPagadoPorArticulo) {
        this.precioPagadoPorArticulo = precioPagadoPorArticulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(id, compra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
