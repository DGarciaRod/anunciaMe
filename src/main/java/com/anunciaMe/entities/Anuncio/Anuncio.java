package com.anunciaMe.entities.Anuncio;

import com.anunciaMe.entities.Categoria.Categoria;
import com.anunciaMe.entities.Usuario.Usuario;
import com.anunciaMe.entities.Imagen.Imagen;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="anuncios")
public class Anuncio {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private BigDecimal precio;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria")
    private Categoria categoria;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedor")
    private Usuario vendedor;

    @OneToMany(mappedBy="anuncio")
    private List<Imagen> imagenes;
    public Anuncio() {
    }

    public Anuncio(String nombre, String descripcion, BigDecimal precio, Categoria categoria, Usuario vendedor, List<Imagen> imagenes) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.vendedor = vendedor;
        this.imagenes = imagenes;
    }

    public Anuncio(String id) {
        this.id = id;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public List<String> getImagenesStr() {
        List<String> ls = new ArrayList<>();
        for(Imagen i: imagenes){
            ls.add(i.getData());
        }
        return ls;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anuncio anuncio = (Anuncio) o;
        return Objects.equals(id, anuncio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, categoria, vendedor);
    }
}
