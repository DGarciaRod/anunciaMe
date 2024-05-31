package com.anunciaMe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaController {
    @GetMapping(value = {
            //Redireccionamos todas las llamadas get que no sean a /api al frontend
            // La dir principal
            "/",
            // Las del formato /x que no sean /index.html (para no causar un bucle), api o assets (imagenes), tambien
            //evitamos cargar archivos (rutas terminadas en .*) para no evitar que carguen los .js o .css
            "/{path:^(?!index\\.html$|api$|assets$|.*\\..*+$).*$}",
            // Las del formato /x/*, lo mismo que en el paso anterior
            "/{path:^(?!index\\.html$|api$|assets$|.*\\..*+$).*$}/**"
    })
    public String redirect() {
        return "forward:/index.html";
    }
}