import {Component, Input} from '@angular/core';
import {NgClass, NgIf} from "@angular/common";

@Component({
  selector: 'app-input-button',
  standalone: true,
  imports: [
    NgIf,
    NgClass
  ],
  templateUrl: './input-button.component.html',
  styleUrl: './input-button.component.css'
})
export class InputButtonComponent {
  @Input() onClick:(()=>any) = ()=>{};
  @Input()label=""
  @Input()formStatus:string='INVALID';
}
