package com.anunciaMe;

import com.anunciaMe.entities.Anuncio.Anuncio;
import com.anunciaMe.entities.Anuncio.AnuncioDao;
import com.anunciaMe.entities.Categoria.Categoria;
import com.anunciaMe.entities.Categoria.CategoriaDao;
import com.anunciaMe.entities.Compra.Compra;
import com.anunciaMe.entities.Compra.CompraDao;
import com.anunciaMe.entities.Review.Review;
import com.anunciaMe.entities.Review.ReviewDao;
import com.anunciaMe.entities.Usuario.Usuario;
import com.anunciaMe.entities.Usuario.UsuarioDao;
import com.anunciaMe.services.anuncioService.AnuncioServiceImpl;
import com.anunciaMe.services.compraService.CompraServiceImpl;
import com.anunciaMe.services.errors.UserAlreadyExistis;
import com.anunciaMe.services.userService.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AnunciaMeAppTests {
    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private AnuncioDao anuncioDao;
    @Autowired
    private CompraDao compraDao;
    @Autowired
    private UserService userService;
    @Autowired
    private CompraServiceImpl compraService;
    @Autowired
    private AnuncioServiceImpl anuncioService;
    @Autowired
    private CategoriaDao categoriaDao;
    @Autowired
    private UsuarioDao usuarioDao;

    @Test
    void testRegistrarUsuarioConElMismoNombre() {
        userService.registerUser("pepe", "pepe", "1234");
        Assertions.assertThrows(UserAlreadyExistis.class,
                () -> userService.registerUser("pepe", "pepe", "1234"));
    }

    @Test
    void obtenerReviewDeCompra() {
        Usuario comprador = userService.registerUser("pepe", "pepe", "1234");
        Usuario vendedor = userService.registerUser("marta", "marta", "1234");
        Categoria categoria = categoriaDao.save(new Categoria("categoria"));
        Anuncio anuncio = anuncioService.CrearAnuncio(vendedor.getId(), "anuncio", "Anuncio",
                new BigDecimal(34), categoria.getId(), new ArrayList<>());
        Compra compra = compraService.RealizarCompra(anuncio.getId(), comprador.getId(), 2);
        String token = userService.generateTokenForUser(comprador);
        Review review = compraService.escribirReview(token, compra.getId(), 3, "malo");
        Review reviewFound = compraService.obtenerReviewDeCompra(compra.getId());
        Assertions.assertEquals(review.getId(), reviewFound.getId());
        Compra compra2 = compraService.RealizarCompra(anuncio.getId(), comprador.getId(), 2);
        Review reviewFound2 = compraService.obtenerReviewDeCompra(compra2.getId());
        Assertions.assertNull(reviewFound2);
    }
    @Test
    void obtenerCalificacionMediaYComprasTotalesAnuncio() {
        Integer cal1 = 5;
        Integer cal2 = 2;
        Usuario comprador = userService.registerUser("pepe", "pepe", "1234");
        Usuario vendedor = userService.registerUser("marta", "marta", "1234");
        Categoria categoria = categoriaDao.save(new Categoria("categoria"));
        Anuncio anuncio = anuncioService.CrearAnuncio(vendedor.getId(), "anuncio", "Anuncio",
                new BigDecimal(34), categoria.getId(), new ArrayList<>());
        Compra compra = compraService.RealizarCompra(anuncio.getId(), comprador.getId(), 2);
        String token = userService.generateTokenForUser(comprador);
        Review review = compraService.escribirReview(token, compra.getId(), cal1, "malo");
        Compra compra2 = compraService.RealizarCompra(anuncio.getId(), comprador.getId(), 2);
        Review review2 = compraService.escribirReview(token, compra2.getId(), cal2, "malo");
        Float calAnuncio=anuncioDao.getCalificacionMedia(anuncio);
        Assertions.assertEquals((float) (cal1 + cal2) /2, calAnuncio);
        Integer comprasTotales = anuncioDao.getComprasTotales(anuncio);
        Assertions.assertEquals(2, comprasTotales);
    }
    @Test
    void obtenerCalificacionMediaUsuario() {
        Integer cal1 = 5;
        Integer cal2 = 2;
        Usuario comprador = userService.registerUser("pepe", "pepe", "1234");
        Usuario vendedor = userService.registerUser("marta", "marta", "1234");
        Categoria categoria = categoriaDao.save(new Categoria("categoria"));
        Anuncio anuncio = anuncioService.CrearAnuncio(vendedor.getId(), "anuncio", "Anuncio",
                new BigDecimal(34), categoria.getId(), new ArrayList<>());
        Compra compra = compraService.RealizarCompra(anuncio.getId(), comprador.getId(), 2);
        String token = userService.generateTokenForUser(comprador);
        Review review = compraService.escribirReview(token, compra.getId(), cal1, "malo");
        Compra compra2 = compraService.RealizarCompra(anuncio.getId(), comprador.getId(), 2);
        Review review2 = compraService.escribirReview(token, compra2.getId(), cal2, "malo");
        Float calVendedor=usuarioDao.getCalificacionMedia(vendedor);
        Assertions.assertEquals((float) (cal1 + cal2) /2, calVendedor);
    }

}
