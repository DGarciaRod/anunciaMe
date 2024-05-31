import {Component, Input} from '@angular/core';
import {FormGroup, ReactiveFormsModule} from "@angular/forms";
import {NgClass} from "@angular/common";

@Component({
  selector: 'app-input-textarea',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgClass
  ],
  templateUrl: './input-textarea.component.html',
  styleUrl: './input-textarea.component.css'
})
export class InputTextareaComponent {
  // @ts-ignore
  @Input() parent: FormGroup;
  @Input() label="";
  @Input() key="";
  @Input()fieldError:boolean= false;
}
