import {Component, EventEmitter, Input, Output} from '@angular/core';
import {faStar} from "@fortawesome/free-solid-svg-icons";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {NgClass} from "@angular/common";
import {selectingEvent} from "../SelectingEvent";

@Component({
  selector: 'app-review-stars-star',
  standalone: true,
  imports: [
    FaIconComponent,
    NgClass
  ],
  templateUrl: './review-stars-star.component.html',
  styleUrl: './review-stars-star.component.css'
})



export class ReviewStarsStarComponent {
  @Input() index: Number = 0
  @Input() selecting: boolean = false
  @Input() selectedIndex: Number = 0
  @Input() disabled: boolean = false
  @Input() selectingIndex: Number = 0
  @Output() valueEmitter = new EventEmitter<Number>
  @Output() selectionValueEmitter = new EventEmitter<selectingEvent>
  @Output() selectigValueEmitter = new EventEmitter<Boolean>
  setValue: (i: Number) => any = (i: Number) => {
    this.valueEmitter.emit(i)
  }

  onMouseOn: (selecting:boolean, value: Number) => any = (selecting:boolean, value: Number) => {
    let event=new selectingEvent(true, value)
    this.selectionValueEmitter.emit(event)
  }

  onMouseOut: (selecting:boolean, value: Number) => any = (selecting:boolean, value: Number) => {
    this.selectionValueEmitter.emit(new selectingEvent(false, value))
  }

  setSelectingValue: (i: Number) => any = (i: Number) => {
    this.valueEmitter.emit(i)
  }


  protected readonly faStar = faStar;
}
