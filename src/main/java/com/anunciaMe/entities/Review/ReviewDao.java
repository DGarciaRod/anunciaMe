package com.anunciaMe.entities.Review;

import com.anunciaMe.entities.Anuncio.Anuncio;
import com.anunciaMe.entities.Compra.Compra;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReviewDao extends PagingAndSortingRepository<Review, Long>, CrudRepository<Review, Long> {
    @Query("select new Review(R.id, R.compra, R.calificacion, R.mensaje, C.comprador) from Review R " +
            "join Compra C on R.compra.id=C.id " +
            "where R.id=:id")
    Optional<Review> findById(@Param("id") String id);
    @Query("select new Review(R.id, R.compra, R.calificacion, R.mensaje, C.comprador) from Review R join Compra C on " +
            "R.compra.id=C.id " +
            "where C=:compra")
    Optional<Review> findByCompra(@Param("compra") Compra compra);

    @Query(
            "select new Review(R.id, R.compra, R.calificacion, R.mensaje, C.comprador) from Review R join Compra C on R.compra.id = C.id " +
                    "join Anuncio A on A.id=C.anuncio.id " +
                    "where A=:anuncio"
    )
    Slice<Review> findByAnuncio(@Param("anuncio") Anuncio Anuncio, Pageable pageable);
}
