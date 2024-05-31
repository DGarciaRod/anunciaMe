import {Component, Input} from '@angular/core';
import {NgClass} from "@angular/common";

@Component({
  selector: 'app-label-and-value',
  standalone: true,
  imports: [
    NgClass
  ],
  templateUrl: './label-and-value.component.html',
  styleUrl: './label-and-value.component.css'
})
export class LabelAndValueComponent {
@Input() separate = false
}
