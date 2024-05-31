import {Component, Input} from '@angular/core';
import {faCircleExclamation, faStar} from "@fortawesome/free-solid-svg-icons";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {ReviewStarsStarComponent} from "./review-stars-star/review-stars-star.component";
import {NgForOf} from "@angular/common";
import {selectingEvent} from "./SelectingEvent";

@Component({
  selector: 'app-review-stars',
  standalone: true,
  imports: [
    FaIconComponent,
    ReviewStarsStarComponent,
    NgForOf
  ],
  templateUrl: './review-stars.component.html',
  styleUrl: './review-stars.component.css'
})
export class ReviewStarsComponent {
  @Input() initialValue:Number=1
  @Input() numberOfStars:Number=5
  value:Number=1
  @Input() disabled:boolean=false
  selecting:boolean=false
  selectingValue:Number=1
  @Input() onChange:(data:Number)=>any=()=>{};

  setSelecting = (a:boolean)=>{
    if(this.disabled)
      return
    this.selecting=a
  }

  onMouseOn=(se: selectingEvent)=>{
    if(this.disabled)
      return
    this.selectingValue=se.selectionValue;
    console.log(se.selectionValue)
  }

  onMouseClick=(index: Number)=>{
    if(this.disabled)
      return
    this.value=index;
    this.selecting=true
    this.onChange(index)
  }
    ngOnInit(){
    console.log(this.initialValue)
    this.value=this.initialValue;
    }
    protected readonly faCircleExclamation = faCircleExclamation;
  protected readonly faStar = faStar;
}
