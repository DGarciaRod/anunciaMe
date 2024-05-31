import {Component, Input} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {NgClass, NgIf} from "@angular/common";

@Component({
  selector: 'app-input-precio',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf,
    NgClass
  ],
  templateUrl: './input-precio.component.html',
  styleUrl: './input-precio.component.css'
})
export class InputPrecioComponent {
  // @ts-ignore
  @Input() parent: FormGroup;
  @Input() label="";
  @Input() key="";
  @Input() type="text";
  @Input()fieldError:boolean= false;
}
