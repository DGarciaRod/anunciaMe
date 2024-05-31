import {Component, inject, Input} from '@angular/core';
import {NgIf, NgOptimizedImage} from "@angular/common";
import {Router} from "@angular/router";
import {environment} from "../../../../../../../../environments/environment";

@Component({
  selector: 'app-resultado',
  standalone: true,
  imports: [
    NgOptimizedImage,
    NgIf
  ],
  templateUrl: './resultado.component.html',
  styleUrl: './resultado.component.css'
})
export class ResultadoComponent {
  @Input() resultado= {
    descripcion: "",
    nombre: "",
    precio: 0,
    categoria: "",
    vendedor: "",
    id: "",
    imagenes: [],
  }
  router=inject(Router)
  irAAnuncio(){
    this.router.navigate(["/home/anuncio/"+this.resultado.id])
  }
  getRutaImg(){
    return this.resultado.imagenes.length>0?this.resultado.imagenes[0]:environment.defaultImg
  }
}
