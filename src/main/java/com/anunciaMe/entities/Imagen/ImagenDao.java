package com.anunciaMe.entities.Imagen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImagenDao extends CrudRepository<Imagen, Long> {


    List<Imagen> findAllByAnuncio_Id(@Param("anuncio") String anuncio);

}
