import {Component, inject, Input} from '@angular/core';
import {faArrowLeft, faArrowRight} from "@fortawesome/free-solid-svg-icons";
import {NgIf} from "@angular/common";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {AnunciosService} from "../../../services/anuncios.service";

@Component({
  selector: 'app-prev-and-next-page',
  standalone: true,
  imports: [
    NgIf,
    FaIconComponent
  ],
  templateUrl: './prev-and-next-page.component.html',
  styleUrl: './prev-and-next-page.component.css'
})
export class PrevAndNextPageComponent {
  anuncioService = inject(AnunciosService)
  @Input() showPrevButtonCond:boolean=false
  @Input() showNextButtonCond:boolean=false
  @Input() goToPrevPage:()=>any=()=>{}
  @Input() goToNextPage:()=>any=()=>{}
  @Input() pageNum:Number=0
    protected readonly faArrowLeft = faArrowLeft;
    protected readonly faArrowRight = faArrowRight;
}
