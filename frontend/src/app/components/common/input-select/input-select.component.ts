import {Component, Input} from '@angular/core';
import {FormControlName, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {List} from "postcss/lib/list";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-input-select',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgForOf,
    NgIf
  ],
  templateUrl: './input-select.component.html',
  styleUrl: './input-select.component.css'
})
export class InputSelectComponent {
  // @ts-ignore
  @Input() parent: FormGroup;
  @Input() optionList: any[] = [];
  @Input() key="";
  @Input() label="";
  @Input() placeholder="";
  // @ts-ignore
  @Input() formControlName:FormControlName;
}
