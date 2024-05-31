package com.anunciaMe.entities.Anuncio;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface AnuncioDao extends CrudRepository<Anuncio, Long>, PagingAndSortingRepository<Anuncio, Long> {
    Optional<Anuncio> findById(String id);



    @Query("select distinct new AnuncioConInfo(A.id,A.nombre, A.descripcion, A.precio, C.nombre, U.nombre, C.id, U.id) " +
            "from Anuncio A left join Categoria C on A.categoria.id=C.id " +
            "left join Usuario U on A.vendedor.id=U.id " +
            "where (" +
            "(:texto is null or (lower(A.nombre) like lower(concat('%', :texto, '%'))))" +
            "or (:texto is null or (lower(A.descripcion) like lower(concat('%', :texto, '%'))))" +
            ")" +
            "and (:categoria is null or (lower(A.categoria) like lower(concat('%', :categoria, '%'))))" +
            "and (:minPrice is null or A.precio>=:minPrice) " +
            "and (:maxPrice is null or A.precio<=:maxPrice) "

    )
    Slice<AnuncioConInfo> buscarAnuncios(@Param("texto") String texto, @Param("categoria") String categoria,
                                         @Param("minPrice") BigDecimal minPrice,
                                         @Param("maxPrice") BigDecimal maxPrice, Pageable pageable);

    @Query(
            "select distinct new AnuncioConInfo(A.id,A.nombre, A.descripcion, A.precio, C.nombre, U.nombre, C.id, U.id) " +
                    "from Anuncio A left join Categoria C on A.categoria.id=C.id " +
                    "left join Usuario U on A.vendedor.id=U.id " +
                    "where A.id=:id"
    )
    AnuncioConInfo buscarAnuncioPorId(@Param("id") String id);

    @Query(
            "select coalesce(avg(R.calificacion),0) from Anuncio A join Compra C on A.id=C.anuncio.id join Review R on C.id=R.compra.id where A=:anuncio"
    )
    Float getCalificacionMedia(@Param("anuncio") Anuncio anuncio);

    @Query(
            "select count(C) from Anuncio A join Compra C on A.id=C.anuncio.id where A=:anuncio"
    )
    Integer getComprasTotales(@Param("anuncio") Anuncio anuncio);

    @Query(
            "select count(C) from Anuncio A join Compra C on A.id=C.anuncio.id join Review R on R.compra.id=C.id where A=:anuncio"
    )
    Integer getReviewsTotales(@Param("anuncio") Anuncio anuncio);
}


