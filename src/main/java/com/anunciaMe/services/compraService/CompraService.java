package com.anunciaMe.services.compraService;

import com.anunciaMe.entities.Compra.Compra;
import com.anunciaMe.entities.Review.Review;
import com.anunciaMe.services.Page;

public interface CompraService {
    public Compra FindById(String id);
    public Compra RealizarCompra(String anuncioId, String compradorId, Integer cantidad);
    public Page<Compra> obtenerPorAnuncio(String anuncioId, String orderBy, String sortOrder, int pageNumber, int pageSize);
    public Page<Compra> obtenerPorVendedor(String vendedorId, String orderBy, String sortOrder, int pageNumber, int pageSize);
    public Page<Compra> obtenerPorComprador(String vendedorId, String orderBy, String sortOrder, int pageNumber, int pageSize);
    public Review escribirReview(String usrToken, String compraId, Integer calificacion, String mensaje);
    public Review obtenerReviewDeCompra(String compraId);
    public Page<Review> obtenerReviewsDeAnuncio(String anuncioId, String orderBy, String sortOrder, int pageNumber, int pageSize);
}
