import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-auth-panel',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './auth-panel.component.html',
  styleUrl: './auth-panel.component.css'
})
export class AuthPanelComponent {

}
