package com.anunciaMe.entities.Usuario;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioDao  extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findById(String id);
    Optional<Usuario> findByUsuario(String usuario);

    @Query(
            "select COUNT(*) from Usuario U join Anuncio A on A.vendedor.id=U.id " +
                    "join Compra C on C.anuncio.id=A.id where U=:usr"
    )
    Integer getNumVentas(@Param("usr") Usuario usr);

    @Query(
            "select COUNT(*) from Usuario U join Compra C on C.comprador.id=U.id where U=:usr"
    )
    Integer getNumCompras(@Param("usr") Usuario usr);
    @Query(
            "select coalesce(avg(R.calificacion),0) from Usuario U join Anuncio A on U.id=A.vendedor.id " +
                    "join Compra C on C.anuncio.id=A.id join Review R on R.compra.id = C.id " +
                    "where U=:usuario"
    )
    Float getCalificacionMedia(@Param("usuario") Usuario usuario);

    @Query(
            "select coalesce(sum(R.calificacion),0) from Usuario U join Anuncio A on U.id=A.vendedor.id " +
                    "join Compra C on C.anuncio.id=A.id join Review R on R.compra.id = C.id " +
                    "where U=:usuario"
    )
    Integer getNumReviewsRecibidas(@Param("usuario") Usuario usuario);
}
