import {Component, inject} from '@angular/core';
import {SimpleFormComponent} from "../../../../../components/common/simple-form/simple-form.component";
import {InputFieldComponent} from "../../../../../components/common/input-field/input-field.component";
import {FormBuilder, Validators} from "@angular/forms";
import {ListaResultadosComponent} from "./lista-resultados/lista-resultados.component";
import {BuscadorComponent} from "./buscador/buscador.component";
import {AnunciosService} from "../../../../../services/anuncios.service";
import {NgIf} from "@angular/common";
import {PanelTitleComponent} from "../../../../../components/common/panel-title/panel-title.component";

@Component({
  selector: 'app-buscar-anuncios',
  standalone: true,
    imports: [
        SimpleFormComponent,
        InputFieldComponent,
        ListaResultadosComponent,
        BuscadorComponent,
        NgIf,
        PanelTitleComponent
    ],
  templateUrl: './buscar-anuncios.component.html',
  styleUrl: './buscar-anuncios.component.css'
})
export class BuscarAnunciosComponent {
  anunciosService=inject(AnunciosService)
  ngOnInit(){
    this.anunciosService.buscarAnuncio(null, null,null, null, null, null, 0)
  }

  ngOnDestroy(){
    this.anunciosService.limpiarBusqueda();
  }
}
