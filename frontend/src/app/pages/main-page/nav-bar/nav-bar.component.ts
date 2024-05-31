import { Component } from '@angular/core';
import {NavBarButtonComponent} from "./nav-bar-button/nav-bar-button.component";
import {UsrButtonComponent} from "./usr-button/usr-button.component";
import {faCircle, faHome, faPlusCircle, faUser} from "@fortawesome/free-solid-svg-icons";
import {IconDefinition} from "@fortawesome/fontawesome-svg-core";

@Component({
  selector: 'app-nav-bar',
  standalone: true,
  imports: [
    NavBarButtonComponent,
    UsrButtonComponent
  ],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {
  a=faCircle

  protected readonly faUser = faUser;
  protected readonly faPlusCircle = faPlusCircle;
  protected readonly faHome = faHome;
}
