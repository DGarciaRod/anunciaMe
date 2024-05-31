package com.anunciaMe.services.compraService;

import com.anunciaMe.services.Page;
import com.anunciaMe.entities.Anuncio.Anuncio;
import com.anunciaMe.entities.Anuncio.AnuncioDao;
import com.anunciaMe.entities.Compra.Compra;
import com.anunciaMe.entities.Compra.CompraDao;
import com.anunciaMe.entities.Review.Review;
import com.anunciaMe.entities.Review.ReviewDao;
import com.anunciaMe.entities.Usuario.Usuario;
import com.anunciaMe.entities.Usuario.UsuarioDao;
import com.anunciaMe.services.errors.AlreadyReviewed;
import com.anunciaMe.services.errors.InvalidLoginError;
import com.anunciaMe.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private AnuncioDao anuncioDao;
    @Autowired
    private CompraDao compraDao;
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private UserService userService;

    public Compra FindById(String id) {
        Optional<Compra> compraOpt = compraDao.findById(id);
        if (compraOpt.isEmpty())
            throw new RuntimeException();
        return compraOpt.get();
    }

    public Compra RealizarCompra(String anuncioId, String compradorId, Integer cantidad) {
        Optional<Anuncio> anuncioOpt = anuncioDao.findById(anuncioId);
        if (anuncioOpt.isEmpty())
            throw new RuntimeException();
        Optional<Usuario> compradorOpt = usuarioDao.findById(compradorId);
        if (compradorOpt.isEmpty())
            throw new RuntimeException();
        Compra compra = new Compra(anuncioOpt.get(), compradorOpt.get(), cantidad);
        return compraDao.save(compra);
    }

    public Page<Compra> obtenerPorAnuncio(String anuncioId, String orderBy, String sortOrder, int pageNumber, int pageSize) {
        System.out.println(anuncioId);
        Optional<Anuncio> anuncioOpt = anuncioDao.findById(anuncioId);
        if (anuncioOpt.isEmpty())
            throw new RuntimeException();
        Sort sort = Sort.by(Objects.equals(sortOrder, "asc") ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy != null ? orderBy : "fecha");
        Slice<Compra> slice = compraDao.findByAnuncio(anuncioOpt.get(), PageRequest.of(pageNumber, pageSize).withSort(sort));
        return new Page<>(slice.getContent(), slice.hasNext());
    }


    public Page<Compra> obtenerPorVendedor(String vendedorId, String orderBy, String sortOrder, int pageNumber, int pageSize) {
        Optional<Usuario> usuarioOpt = usuarioDao.findById(vendedorId);
        if (usuarioOpt.isEmpty())
            throw new RuntimeException();
        Sort sort = Sort.by(Objects.equals(sortOrder, "asc") ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy != null ? orderBy : "fecha");
        Slice<Compra> slice = compraDao.findByAnuncio_Vendedor(usuarioOpt.get(), PageRequest.of(pageNumber, pageSize).withSort(sort));
        return new Page<>(slice.getContent(), slice.hasNext());
    }

    public Page<Compra> obtenerPorComprador(String vendedorId, String orderBy, String sortOrder, int pageNumber, int pageSize) {
        Optional<Usuario> usuarioOpt = usuarioDao.findById(vendedorId);
        if (usuarioOpt.isEmpty())
            throw new RuntimeException();
        Sort sort = Sort.by(Objects.equals(sortOrder, "asc") ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy != null ? orderBy : "fecha");
        Slice<Compra> slice = compraDao.findByComprador(usuarioOpt.get(), PageRequest.of(pageNumber, pageSize).withSort(sort));
        return new Page<>(slice.getContent(), slice.hasNext());
    }

    public Review escribirReview(String usrToken, String compraId, Integer calificacion, String mensaje){
        Usuario user = userService.loginFromToken(usrToken);
        Optional<Compra> compraOpt = compraDao.findById(compraId);
        if(compraOpt.isEmpty())
            throw new RuntimeException();
        Compra compra = compraOpt.get();
        if(!(user.getId().equals(compra.getComprador().getId()))){
            throw new InvalidLoginError();
        }
        Optional<Review> reviewOpt = reviewDao.findByCompra(compra);
        if(reviewOpt.isPresent())
            throw new AlreadyReviewed();
        return reviewDao.save(new Review(compra, calificacion, mensaje));
    }

    public Review obtenerReviewDeCompra(String compraId){
        Optional<Compra> compraOpt = compraDao.findById(compraId);
        if(compraOpt.isEmpty())
            throw new RuntimeException();
        Optional<Review> reviewOpt = reviewDao.findByCompra(compraOpt.get());
        return reviewOpt.orElse(null);
    }

    public Page<Review> obtenerReviewsDeAnuncio(String anuncioId, String orderBy, String sortOrder, int pageNumber, int pageSize){
        Optional<Anuncio> anuncioOpt = anuncioDao.findById(anuncioId);
        if(anuncioOpt.isEmpty())
            throw new RuntimeException();
        Sort sort = Sort.by(Objects.equals(sortOrder, "asc") ? Sort.Direction.ASC : Sort.Direction.DESC, orderBy != null ? orderBy : "C.fecha");
        Slice<Review> reviews = reviewDao.findByAnuncio(anuncioOpt.get(), PageRequest.of(pageNumber, pageSize).withSort(sort));

        return new Page<>(reviews.getContent(), reviews.hasNext());
    }
}
