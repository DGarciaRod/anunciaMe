package com.anunciaMe.api.dtos.conversors;

import com.anunciaMe.api.dtos.CompraDto;
import com.anunciaMe.entities.Compra.Compra;

import java.util.ArrayList;
import java.util.List;

public class CompraConversor {
    public static CompraDto compraToDto(Compra compra){
        return new CompraDto(compra.getId(), compra.getAnuncio().getId(), compra.getComprador().getId(), compra.getCantidad(), compra.getPrecioPagadoPorArticulo(), compra.getFecha());
    }
    public static List<CompraDto> compraToDtos(List<Compra> compras){
        List<CompraDto> dtos = new ArrayList<>();
        for(Compra compra: compras){
            dtos.add(compraToDto(compra));
        }
        return dtos;
    }
}
