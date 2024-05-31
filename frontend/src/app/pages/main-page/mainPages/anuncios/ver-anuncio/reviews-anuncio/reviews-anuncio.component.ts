import {Component, inject, Input} from '@angular/core';
import {Page} from "../../../../../../model/Page";
import {Review} from "../../../../../../model/Review";
import {AnunciosService} from "../../../../../../services/anuncios.service";
import {LoginService} from "../../../../../../services/login.service";
import {ReviewComponent} from "../../../../../../components/review/review.component";
import {NgForOf, NgIf} from "@angular/common";
import {
  PrevAndNextPageComponent
} from "../../../../../../components/common/prev-and-next-page/prev-and-next-page.component";

@Component({
  selector: 'app-reviews-anuncio',
  standalone: true,
  imports: [
    ReviewComponent,
    NgForOf,
    PrevAndNextPageComponent,
    NgIf
  ],
  templateUrl: './reviews-anuncio.component.html',
  styleUrl: './reviews-anuncio.component.css'
})
export class ReviewsAnuncioComponent {
  reviews:Page<Review>=new Page<Review>()
  anuncioService=inject(AnunciosService)
  @Input() idAnuncio:String=""
  searchParams={
    "pageNum":0,
  }
  prevPage=()=>{
    this.searchParams.pageNum--;
    this.anuncioService.obtenerReviewsAnuncio(
      this.idAnuncio, this.searchParams.pageNum, null, null,
      (data:Page<Review>)=> {
      this.reviews=data
    })
  }
  nextPage=()=>{
    this.searchParams.pageNum++;
    this.anuncioService.obtenerReviewsAnuncio(
      this.idAnuncio, this.searchParams.pageNum, null, null,
      (data:Page<Review>)=> {
        this.reviews=data
      })
  }
  ngOnInit(){
    console.log(this.idAnuncio)
    this.anuncioService.obtenerReviewsAnuncio(this.idAnuncio, 0, null, null,
      (data)=>{
        this.reviews=data
      })
  }
}
