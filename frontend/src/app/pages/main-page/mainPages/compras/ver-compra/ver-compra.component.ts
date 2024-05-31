import {Component, inject} from '@angular/core';
import {Compra} from "../../../../../model/Compra";
import {AnunciosService} from "../../../../../services/anuncios.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Anuncio} from "../../../../../model/Anuncio";
import {LoginService} from "../../../../../services/login.service";
import {Usuario} from "../../../../../model/Usuario";
import {NgIf} from "@angular/common";
import {ReviewFormComponent} from "../../../../../components/review-form/review-form.component";
import {Review} from "../../../../../model/Review";
import {ReviewComponent} from "../../../../../components/review/review.component";
import {LabelAndValueComponent} from "../../../../../components/label-and-value/label-and-value.component";
import {PanelTitleComponent} from "../../../../../components/common/panel-title/panel-title.component";

@Component({
  selector: 'app-ver-compra',
  standalone: true,
  imports: [
    NgIf,
    ReviewFormComponent,
    ReviewComponent,
    LabelAndValueComponent,
    PanelTitleComponent
  ],
  templateUrl: './ver-compra.component.html',
  styleUrl: './ver-compra.component.css'
})
export class VerCompraComponent {
  router = inject(Router)
  anuncioService = inject(AnunciosService)
  loginService = inject(LoginService)
  compra: Compra=new Compra();
  anuncio: Anuncio = new Anuncio()
  comprador:Usuario=new Usuario()
  review:Review|null=null
  constructor(private route: ActivatedRoute) {
  }
  getFormatedDate():String{
    return new Date(this.compra.fecha).toLocaleDateString('es-es', { weekday:"long", year:"numeric", month:"short", day:"numeric"})
  }
  isReviewed=():boolean=>this.review!=null
  onReview=(review:Review)=>{
    this.review=review
  }
  getNewReview(){return new Review()}
  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id)
      this.anuncioService.obtenerCompra(id, (dataCompra) => {
        this.compra = dataCompra;
        this.anuncioService.obtenerReviewDeCompra(dataCompra.id,
          (data)=>{
            if(data.done)
              this.review=data.review
          })
        this.anuncioService.obtenerAnuncio(this.compra.anuncio, (data)=>{
          this.anuncio=data
        })
        this.loginService.getUserInfo(this.compra.comprador, (data)=>{
          this.comprador=data
        })
      })
  }


  irAlAnuncio(){
    this.router.navigate(["/home/anuncio/"+this.anuncio.id])
    return false
  }

  protected readonly Review = Review;
  protected readonly Date = Date;
}
