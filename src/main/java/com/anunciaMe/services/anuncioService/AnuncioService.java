package com.anunciaMe.services.anuncioService;

import com.anunciaMe.entities.Anuncio.Anuncio;
import com.anunciaMe.entities.Anuncio.AnuncioConInfo;
import com.anunciaMe.entities.Categoria.Categoria;
import com.anunciaMe.services.Page;

import java.math.BigDecimal;
import java.util.List;

public interface AnuncioService {
    public Anuncio CrearAnuncio(String vendedorId, String nombre, String descripcion, BigDecimal precio,
                                String categoriaId, List<String> imagenes);
    public List<Categoria> ObtenerCategorias();
    public Page<AnuncioConInfo> BuscarAnuncios(String texto, String categoria, BigDecimal minPrice,
                                               BigDecimal maxPrice, String orderBy, String sortOrder, int pageNumber,
                                               int pageSize);
    public AnuncioConInfo ObtenerAnuncio(String id);
    public Integer getComprasTotales(String id);
    public Integer getReviwsTotales(String id);
    public Float getCalificacionMedia(String id);
    }
