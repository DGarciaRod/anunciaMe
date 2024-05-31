import {Component, inject, Input} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {ActivatedRoute} from "@angular/router";
import {AnunciosService, filtrosBusquedaCompra} from "../../../../../services/anuncios.service";
import {ComprarAnuncioComponent} from "./comprar-anuncio/comprar-anuncio.component";
import {faArrowLeft, faArrowRight, faCircleExclamation} from "@fortawesome/free-solid-svg-icons";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {Anuncio} from "../../../../../model/Anuncio";
import {LoginService} from "../../../../../services/login.service";
import {Review} from "../../../../../model/Review";
import {ReviewComponent} from "../../../../../components/review/review.component";
import {Page} from "../../../../../model/Page";
import {ReviewsAnuncioComponent} from "./reviews-anuncio/reviews-anuncio.component";
import {ReviewStarsComponent} from "../../../../../components/review-stars/review-stars.component";
import {Usuario} from "../../../../../model/Usuario";
import {UserStats} from "../../../../../model/UserStats";
import {AnuncioStats} from "../../../../../model/AnuncioStats";
import {ListarComprasComponent} from "../../compras/listar-compras/listar-compras.component";
import {LabelAndValueComponent} from "../../../../../components/label-and-value/label-and-value.component";
import {PanelTitleComponent} from "../../../../../components/common/panel-title/panel-title.component";

@Component({
  selector: 'app-ver-anuncio',
  standalone: true,
  imports: [
    NgIf,
    ComprarAnuncioComponent,
    FaIconComponent,
    ReviewComponent,
    NgForOf,
    ReviewsAnuncioComponent,
    ReviewStarsComponent,
    ListarComprasComponent,
    LabelAndValueComponent,
    PanelTitleComponent
  ],
  templateUrl: './ver-anuncio.component.html',
  styleUrl: './ver-anuncio.component.css'
})
export class VerAnuncioComponent {
  anuncioService=inject(AnunciosService)
  loginService = inject(LoginService);
  datosAnuncio:Anuncio= {
    descripcion: "desss",
    nombre: "dess",
    precio: 300,
    categoria: "",
    vendedor: "",
    categoriaId: "",
    vendedorId: "",
    imagenes: [],
    id:""
  }
  userStats:UserStats=new UserStats()
  anuncioStats:AnuncioStats=new AnuncioStats()
  imgIndex=0;
  nextImage(){
    if(this.imgIndex<this.datosAnuncio.imagenes.length-1)
      this.imgIndex++
    else
      this.imgIndex=0
  }

  previousImage(){
    if(this.imgIndex>0)
      this.imgIndex--
    else
      this.imgIndex=this.datosAnuncio.imagenes.length-1
  }

  constructor(private route: ActivatedRoute) {}
  ngOnInit() {
    let id = this.route.snapshot.paramMap.get('id');
    if(id) {
      this.anuncioService.getAnuncioStats(id, (data)=>{
        this.anuncioStats=data
      })
      this.anuncioService.obtenerAnuncio(id, (data) => {
        this.datosAnuncio = data
        this.loginService.getUserStats(data.vendedorId, (data)=>{
          console.log(data)
          this.userStats=data
        })
      })

    }

  }

  protected readonly faCircleExclamation = faCircleExclamation;
  protected readonly faArrowLeft = faArrowLeft;
  protected readonly faArrowRight = faArrowRight;
  protected readonly Math = Math;
  protected readonly filtrosBusquedaCompra = filtrosBusquedaCompra;
}
