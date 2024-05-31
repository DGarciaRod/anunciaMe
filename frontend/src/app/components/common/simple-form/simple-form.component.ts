import {Component, Input} from '@angular/core';
import {FormGroup, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-simple-form',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './simple-form.component.html',
  styleUrl: './simple-form.component.css'
})
export class SimpleFormComponent {
// @ts-ignore
  @Input() formGroup:FormGroup;
}
