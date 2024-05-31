package com.anunciaMe.services.anuncioService;

import com.anunciaMe.services.Page;
import com.anunciaMe.entities.Anuncio.Anuncio;
import com.anunciaMe.entities.Anuncio.AnuncioConInfo;
import com.anunciaMe.entities.Anuncio.AnuncioDao;
import com.anunciaMe.entities.Categoria.Categoria;
import com.anunciaMe.entities.Categoria.CategoriaDao;
import com.anunciaMe.entities.Imagen.Imagen;
import com.anunciaMe.entities.Imagen.ImagenDao;
import com.anunciaMe.entities.Usuario.Usuario;
import com.anunciaMe.entities.Usuario.UsuarioDao;
import com.anunciaMe.services.errors.InternalError;
import com.anunciaMe.services.errors.UserNotFoundError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class AnuncioServiceImpl implements AnuncioService {
    @Autowired
    private AnuncioDao anuncioDao;
    @Autowired
    private CategoriaDao categoriaDao;
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private ImagenDao imagenDao;
    public Anuncio CrearAnuncio(String vendedorId, String nombre, String descripcion, BigDecimal precio,
                                String categoriaId, List<String> imagenes){
        Optional<Usuario> usuarioOpt = usuarioDao.findById(vendedorId);
        if(usuarioOpt.isEmpty())
            throw new UserNotFoundError();
        Usuario vendedor = usuarioOpt.get();
        Optional<Categoria> categoriaOpt = categoriaDao.findById(categoriaId);
        if(categoriaOpt.isEmpty())
            throw new InternalError();
        Categoria categoria = categoriaOpt.get();
        List<Imagen> imgList = new ArrayList<>();
        for(String img : imagenes){
            imgList.add(new Imagen(img));
        }
        Anuncio anuncio = new Anuncio(nombre, descripcion, precio, categoria, vendedor, imgList);
        anuncio = anuncioDao.save(anuncio);
        for(String img : imagenes){
            imagenDao.save(new Imagen(anuncio, img));
        }
        return anuncio;
    }

    public List<Categoria> ObtenerCategorias(){
        return categoriaDao.findAll();
    }

    public Page<AnuncioConInfo> BuscarAnuncios(String texto, String categoria, BigDecimal minPrice,
                                               BigDecimal maxPrice, String orderBy, String sortOrder, int pageNumber,
                                               int pageSize){
        Sort sort=Sort.by(Objects.equals(sortOrder, "desc") ?Sort.Direction.DESC:Sort.Direction.ASC, orderBy!=null?orderBy:"precio");;
        Slice<AnuncioConInfo>  slice = anuncioDao.buscarAnuncios(texto, categoria, minPrice, maxPrice, PageRequest.of(pageNumber, pageSize).withSort(sort));
        List<AnuncioConInfo> items = slice.getContent();
        List<AnuncioConInfo> newItems = new ArrayList<>();
        for (AnuncioConInfo anu: items) {
            AnuncioConInfo ao = anu;
            ao.setImagenes(getImgList(ao.getId()));
            newItems.add(ao);
        }
        return new Page<>(newItems, slice.hasNext());
    }
    
    private List<String> getImgList(String anuncioId){
        List<Imagen> lImg= imagenDao.findAllByAnuncio_Id(anuncioId);
        List<String> ls = new ArrayList<>();
        for (Imagen i: lImg) {
            ls.add(i.getData());
        }
        return ls;
    }

    public AnuncioConInfo ObtenerAnuncio(String id){
        AnuncioConInfo an = anuncioDao.buscarAnuncioPorId(id);
        an.setImagenes(getImgList(an.getId()));
        return  an;
    }

    public Integer getComprasTotales(String id){
        Optional<Anuncio> anuncio = anuncioDao.findById(id);
        if(anuncio.isEmpty())
            throw new RuntimeException();
        Integer an = anuncioDao.getComprasTotales(anuncio.get());
        return  an;
    }

    public Integer getReviwsTotales(String id){
        Optional<Anuncio> anuncio = anuncioDao.findById(id);
        if(anuncio.isEmpty())
            throw new RuntimeException();
        Integer an = anuncioDao.getReviewsTotales(anuncio.get());
        return  an;
    }

    public Float getCalificacionMedia(String id){
        Optional<Anuncio> anuncio = anuncioDao.findById(id);
        if(anuncio.isEmpty())
            throw new RuntimeException();
        Float an = anuncioDao.getCalificacionMedia(anuncio.get());
        return  an;
    }
}
