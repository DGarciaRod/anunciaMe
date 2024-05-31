package com.anunciaMe.api.dtos.conversors;

import com.anunciaMe.api.dtos.AnuncioDto;
import com.anunciaMe.entities.Anuncio.Anuncio;
import com.anunciaMe.entities.Anuncio.AnuncioConInfo;

import java.util.ArrayList;
import java.util.List;

public class AnuncioConversor {
    public static AnuncioDto anuncioToDto(Anuncio anuncio){
        return new AnuncioDto(anuncio.getId(), anuncio.getNombre(), anuncio.getDescripcion(),
                anuncio.getCategoria().getNombre(), anuncio.getVendedor().getNombre(),
                anuncio.getPrecio(), anuncio.getImagenesStr(), anuncio.getCategoria().getId(),
                anuncio.getVendedor().getId());
    }
    public static List<AnuncioDto> anunciosToDtos(List<Anuncio> anuncios){
        List<AnuncioDto> dtos = new ArrayList<>();
        for(Anuncio anuncio: anuncios){
            dtos.add(anuncioToDto(anuncio));
        }
        return dtos;
    }
    public static AnuncioDto anuncioCnInfoToDto(AnuncioConInfo anuncio){
        return new AnuncioDto(anuncio.getId(), anuncio.getNombre(), anuncio.getDescripcion(),
                anuncio.getCategoria(), anuncio.getVendedor(), anuncio.getPrecio(), anuncio.getImagenes(), anuncio.getCategoriaId(), anuncio.getVendedorId());
    }
    public static List<AnuncioDto> anunciosConInfoToDtos(List<AnuncioConInfo> anuncios){
        List<AnuncioDto> dtos = new ArrayList<>();
        for(AnuncioConInfo anuncio: anuncios){
            dtos.add(anuncioCnInfoToDto(anuncio));
        }
        return dtos;
    }
}
