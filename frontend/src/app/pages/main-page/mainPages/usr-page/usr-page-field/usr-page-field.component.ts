import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-usr-page-field',
  standalone: true,
  imports: [],
  templateUrl: './usr-page-field.component.html',
  styleUrl: './usr-page-field.component.css'
})
export class UsrPageFieldComponent {
@Input() label="";
@Input() value =";"
}
