package com.anunciaMe.api;

import com.anunciaMe.api.dtos.*;
import com.anunciaMe.services.Page;
import com.anunciaMe.api.dtos.conversors.AnuncioConversor;
import com.anunciaMe.api.dtos.conversors.CategoryConversor;
import com.anunciaMe.api.dtos.conversors.CompraConversor;
import com.anunciaMe.api.dtos.conversors.ReviewConversor;
import com.anunciaMe.entities.Anuncio.Anuncio;
import com.anunciaMe.entities.Anuncio.AnuncioConInfo;
import com.anunciaMe.entities.Compra.Compra;
import com.anunciaMe.entities.Review.Review;
import com.anunciaMe.entities.Usuario.Usuario;
import com.anunciaMe.services.anuncioService.AnuncioService;
import com.anunciaMe.services.compraService.CompraService;
import com.anunciaMe.services.userService.UserService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/anuncios", produces = "application/json;charset=utf-8")
public class AnuncioController {

    @Autowired
    private UserService userService;
    @Autowired
    private AnuncioService anuncioService;
    @Autowired
    private CompraService compraService;

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDto>> ObtenerCategorias() {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(location).body(
                CategoryConversor.categoriasToDtos(anuncioService.ObtenerCategorias()));

    }

    @PostMapping("/crear")
    public ResponseEntity<AnuncioDto> CrearAnuncio(
            @Validated({AnuncioDto.CreateValidations.class}) @RequestBody AnuncioDto anuncioDto, @RequestHeader("token") String token) {
        try {
            Usuario anunciante = userService.loginFromToken(token);
            Anuncio anuncio = anuncioService.CrearAnuncio(anunciante.getId(), anuncioDto.getNombre(),
                    anuncioDto.getDescripcion(), anuncioDto.getPrecio(), anuncioDto.getCategoria(), anuncioDto.getImagenes());
            AnuncioDto out = AnuncioConversor.anuncioToDto(anuncio);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().normalize()
                    .toUri();
            return ResponseEntity.created(location).body(out);
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<PageDto<AnuncioDto>> BuscarAnuncios(@RequestParam(required = false) String texto,
                                                              @RequestParam(required = false) String categoria,
                                                              @RequestParam(required = false) BigDecimal minPrice,
                                                              @RequestParam(required = false) BigDecimal maxPrice,
                                                              @RequestParam(required = false) String orderBy,
                                                              @RequestParam(required = false) String orderSort,
                                                              @RequestParam(defaultValue = "0") int pageNumber,
                                                              @RequestParam(defaultValue = "5") int pageSize) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        Page<AnuncioConInfo> page = anuncioService.BuscarAnuncios(texto, categoria, minPrice, maxPrice, orderBy, orderSort, pageNumber, pageSize);
        return ResponseEntity.created(location).body(new PageDto<>(AnuncioConversor.anunciosConInfoToDtos(page.getItems()), page.getExistMoreItems()));

    }

    @GetMapping("/info")
    public ResponseEntity<AnuncioDto> ObtenerAnuncio(@RequestParam(required = true) String id) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        AnuncioConInfo anuncio = anuncioService.ObtenerAnuncio(id);
        return ResponseEntity.created(location).body(AnuncioConversor.anuncioCnInfoToDto(anuncio));

    }

    @PostMapping("/comprar")
    public ResponseEntity<CompraDto> Comprar(
            @Validated({CompraDto.CreateValidations.class}) @RequestBody CompraDto compraDtoIn, @RequestHeader("token") String token) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        Usuario comprador = userService.loginFromToken(token);
        return ResponseEntity.created(location).body(CompraConversor.compraToDto(
                compraService.RealizarCompra(compraDtoIn.getAnuncio(), comprador.getId(), compraDtoIn.getCantidad())
        ));

    }

    @GetMapping("/compra/info")
    public ResponseEntity<CompraDto> ObtenerCompra(@RequestParam(required = true) String id) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        Compra compra = compraService.FindById(id);
        return ResponseEntity.created(location).body(CompraConversor.compraToDto(compra));

    }

    @GetMapping("/compra/porAnuncio")
    public ResponseEntity<PageDto<CompraDto>> BuscarComprasPorAnuncio(@RequestParam(required = true) String id,
                                                                      @RequestParam(required = false) String orderBy,
                                                                      @RequestParam(required = false) String orderSort,
                                                                      @RequestParam(defaultValue = "0") int pageNumber,
                                                                      @RequestParam(defaultValue = "5") int pageSize) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        Page<Compra> page = compraService.obtenerPorAnuncio(id, orderBy, orderSort, pageNumber, pageSize);
        return ResponseEntity.created(location).body(new PageDto<>(CompraConversor.compraToDtos(page.getItems()), page.getExistMoreItems()));

    }

    @GetMapping("/compra/porVendedor")
    public ResponseEntity<PageDto<CompraDto>> BuscarComprasPorVendedor(@RequestParam(required = true) String id,
                                                                       @RequestParam(required = false) String orderBy,
                                                                       @RequestParam(required = false) String orderSort,
                                                                       @RequestParam(defaultValue = "0") int pageNumber,
                                                                       @RequestParam(defaultValue = "5") int pageSize) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        Page<Compra> page = compraService.obtenerPorVendedor(id, orderBy, orderSort, pageNumber, pageSize);
        return ResponseEntity.created(location).body(new PageDto<>(CompraConversor.compraToDtos(page.getItems()), page.getExistMoreItems()));

    }

    @GetMapping("/compra/porComprador")
    public ResponseEntity<PageDto<CompraDto>> BuscarComprasPorComprador(@RequestParam(required = true) String id,
                                                                        @RequestParam(required = false) String orderBy,
                                                                        @RequestParam(required = false) String orderSort,
                                                                        @RequestParam(defaultValue = "0") int pageNumber,
                                                                        @RequestParam(defaultValue = "5") int pageSize) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        Page<Compra> page = compraService.obtenerPorComprador(id, orderBy, orderSort, pageNumber, pageSize);
        return ResponseEntity.created(location).body(new PageDto<>(CompraConversor.compraToDtos(page.getItems()), page.getExistMoreItems()));

    }

    @PostMapping("/compra/review")
    public ResponseEntity<ReviewDto> Review(
            @Validated({CompraDto.CreateValidations.class}) @RequestBody ReviewDto reviewDtoIn, @RequestHeader("token") String token) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        Review review = compraService.escribirReview(token, reviewDtoIn.getCompra(), reviewDtoIn.getCalificacion(), reviewDtoIn.getMensaje());
        return ResponseEntity.created(location).body(ReviewConversor.toDto(review));
    }

    @GetMapping("/compra/{id}/review")
    public ResponseEntity<ReviewResponse> getReview(@PathVariable  @NotNull String id) {

        try {
            Review review = compraService.obtenerReviewDeCompra(id);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(review!=null?"/../{id}":"").buildAndExpand(review!=null?review.getId():null).normalize()
                    .toUri();
            return ResponseEntity.created(location).body(
                    new ReviewResponse(review != null, review != null?ReviewConversor.toDto(review):null));
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<Page<ReviewDto>> getReviewsAnuncio(@PathVariable String id,
                                                                  @RequestParam(required = false) String orderBy,
                                                                  @RequestParam(required = false) String orderSort,
                                                                  @RequestParam(defaultValue = "0") int pageNumber,
                                                                  @RequestParam(defaultValue = "5") int pageSize) {
        try {
            Page<Review> reviewPage = compraService.obtenerReviewsDeAnuncio(id, orderBy, orderSort, pageNumber, pageSize);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().normalize()
                    .toUri();
            return ResponseEntity.created(location).body(
                    new Page<>(ReviewConversor.toDtos(reviewPage.getItems()), reviewPage.getExistMoreItems())
            );
        } catch (Exception e) {
            throw e;
        }
    }
    @GetMapping("/{id}/stats")
    public ResponseEntity<AnuncioStatsDto> getStatsAnuncio(@PathVariable  @NotNull String id) {

        try {
            Float cal = anuncioService.getCalificacionMedia(id);
            Integer numCompras = anuncioService.getComprasTotales(id);
            Integer numReviews = anuncioService.getReviwsTotales(id);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().normalize()
                    .toUri();
            return ResponseEntity.created(location).body(
                    new AnuncioStatsDto(id, cal, numCompras, numReviews));
        } catch (Exception e) {
            throw e;
        }
    }

}
