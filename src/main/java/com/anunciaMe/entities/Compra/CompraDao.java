package com.anunciaMe.entities.Compra;

import com.anunciaMe.entities.Anuncio.Anuncio;
import com.anunciaMe.entities.Usuario.Usuario;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CompraDao extends CrudRepository<Compra, Long>, PagingAndSortingRepository<Compra, Long> {
    Optional<Compra> findById(@NotEmpty String id);
    Slice<Compra> findByAnuncio(Anuncio anuncio, Pageable pageable);
    Slice<Compra> findByComprador(Usuario comprador, Pageable pageable);

    Slice<Compra> findByAnuncio_Vendedor(Usuario comprador, Pageable pageable);
}

