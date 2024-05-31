import {Component, inject} from '@angular/core';
import {LoginService} from "../../../../services/login.service";
import {RouterLink} from "@angular/router";
import {faCircleExclamation, faUser} from "@fortawesome/free-solid-svg-icons";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";

@Component({
  selector: 'app-usr-button',
  standalone: true,
  imports: [
    RouterLink,
    FaIconComponent
  ],
  templateUrl: './usr-button.component.html',
  styleUrl: './usr-button.component.css'
})
export class UsrButtonComponent {
  loginService=inject(LoginService)
    protected readonly faCircleExclamation = faCircleExclamation;
  protected readonly faUser = faUser;
}
