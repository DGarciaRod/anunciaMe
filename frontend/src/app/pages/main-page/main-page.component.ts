import {Component, inject} from '@angular/core';
import {LoginService} from "../../services/login.service";
import {NavBarComponent} from "./nav-bar/nav-bar.component";
import {RouterOutlet} from "@angular/router";
import {BigPanelComponent} from "../../components/big-panel/big-panel.component";

@Component({
  selector: 'app-main-page',
  standalone: true,
  imports: [
    NavBarComponent,
    RouterOutlet,
    BigPanelComponent
  ],
  templateUrl: './main-page.component.html',
  styleUrl: './main-page.component.css'
})
export class MainPageComponent {
  loginService=inject(LoginService)
  logout(){
    this.loginService.logout()
  }
}
