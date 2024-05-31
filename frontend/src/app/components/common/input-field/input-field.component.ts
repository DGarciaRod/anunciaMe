import {Component, Input} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {NgClass, NgIf} from "@angular/common";

@Component({
  selector: 'app-input-field',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf,
    NgClass
  ],
  templateUrl: './input-field.component.html',
  styleUrl: './input-field.component.css'
})
export class InputFieldComponent {
  // @ts-ignore
  @Input() parent: FormGroup;
  @Input() label="";
  @Input() key="";
  @Input() type="text";
  @Input()fieldError:boolean= false;
}
