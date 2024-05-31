import {Component, inject, Input} from '@angular/core';
import {InputButtonComponent} from "../common/input-button/input-button.component";
import {InputTextareaComponent} from "../common/input-textarea/input-textarea.component";
import {ReviewStarsComponent} from "../review-stars/review-stars.component";
import {SimpleFormComponent} from "../common/simple-form/simple-form.component";
import {Review} from "../../model/Review";
import {Usuario} from "../../model/Usuario";
import {AnunciosService} from "../../services/anuncios.service";
import {LoginService} from "../../services/login.service";
import {UserStats} from "../../model/UserStats";

@Component({
  selector: 'app-review',
  standalone: true,
    imports: [
        InputButtonComponent,
        InputTextareaComponent,
        ReviewStarsComponent,
        SimpleFormComponent
    ],
  templateUrl: './review.component.html',
  styleUrl: './review.component.css'
})
export class ReviewComponent {
  @Input() review:Review=new Review();
  usuario:Usuario=new Usuario();
  userStas:UserStats=new UserStats();
  loginService = inject(LoginService);
  ngOnInit(){
    this.loginService.getUserInfo(this.review.comprador,
      (usr:Usuario)=>{
        this.usuario=usr;
      })
    this.loginService.getUserStats(this.review.comprador,
      (usr:UserStats)=>{
        this.userStas=usr;
      })
  }
}
