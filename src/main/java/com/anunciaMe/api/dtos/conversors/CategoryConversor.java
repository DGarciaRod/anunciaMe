package com.anunciaMe.api.dtos.conversors;

import com.anunciaMe.api.dtos.CategoriaDto;
import com.anunciaMe.entities.Categoria.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoryConversor {
    public static CategoriaDto categoriaToDto(Categoria categoria){
        return new CategoriaDto(categoria.getId(), categoria.getNombre());
    }
    public static List<CategoriaDto> categoriasToDtos(List<Categoria> categorias){
        List<CategoriaDto> dtos = new ArrayList<>();
        for(Categoria categoria: categorias){
            dtos.add(categoriaToDto(categoria));
        }
        return dtos;
    }
}
