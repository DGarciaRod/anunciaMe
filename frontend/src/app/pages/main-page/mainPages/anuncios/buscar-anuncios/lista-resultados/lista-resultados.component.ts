import {Component, inject} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {AnunciosService} from "../../../../../../services/anuncios.service";
import {ResultadoComponent} from "./resultado/resultado.component";
import {faArrowLeft, faArrowRight} from "@fortawesome/free-solid-svg-icons";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {
  PrevAndNextPageComponent
} from "../../../../../../components/common/prev-and-next-page/prev-and-next-page.component";

@Component({
  selector: 'app-lista-resultados',
  standalone: true,
  imports: [
    NgForOf,
    ResultadoComponent,
    FaIconComponent,
    NgIf,
    PrevAndNextPageComponent
  ],
  templateUrl: './lista-resultados.component.html',
  styleUrl: './lista-resultados.component.css'
})
export class ListaResultadosComponent {
  anuncioService = inject(AnunciosService)
  resultados = [
    {
      nombre: "Bici",
      categoria: "cat",
      descripcion: "desc",
      vendedor: "ven",
    },

  ]
    protected readonly faArrowLeft = faArrowLeft;
  protected readonly faArrowRight = faArrowRight;
}
