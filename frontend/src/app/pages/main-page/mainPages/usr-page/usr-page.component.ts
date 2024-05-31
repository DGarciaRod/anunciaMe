import {Component, inject} from '@angular/core';
import {LoginService} from "../../../../services/login.service";
import {NavBarComponent} from "../../nav-bar/nav-bar.component";
import {FloatingPanelComponent} from "../../../../components/floating-panel/floating-panel.component";
import {UsrPageFieldComponent} from "./usr-page-field/usr-page-field.component";
import {ListarComprasComponent} from "../compras/listar-compras/listar-compras.component";
import {Compra} from "../../../../model/Compra";
import {AnunciosService, filtrosBusquedaCompra} from "../../../../services/anuncios.service";
import {Page} from "../../../../model/Page";
import {UserStats} from "../../../../model/UserStats";
import {NgIf} from "@angular/common";
import {ReviewStarsComponent} from "../../../../components/review-stars/review-stars.component";
import {ReviewFormComponent} from "../../../../components/review-form/review-form.component";
import {faDownLong, faExpand, faUpLong, faUser} from "@fortawesome/free-solid-svg-icons";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {LabelAndValueComponent} from "../../../../components/label-and-value/label-and-value.component";
import {PanelTitleComponent} from "../../../../components/common/panel-title/panel-title.component";
import {InputButtonComponent} from "../../../../components/common/input-button/input-button.component";

@Component({
  selector: 'app-usr-page',
  standalone: true,
  imports: [
    NavBarComponent,
    FloatingPanelComponent,
    UsrPageFieldComponent,
    ListarComprasComponent,
    NgIf,
    ReviewStarsComponent,
    ReviewFormComponent,
    FaIconComponent,
    LabelAndValueComponent,
    PanelTitleComponent,
    InputButtonComponent
  ],
  templateUrl: './usr-page.component.html',
  styleUrl: './usr-page.component.css'
})
export class UsrPageComponent {
  loginService=inject(LoginService)
  userStats:UserStats=new UserStats();
  showCompras=false
  showVentas=false
  logout(){
    this.loginService.logout()
  }

   toggleVentas(){
    this.showVentas=!this.showVentas
   }
  toggleCompras(){
    this.showCompras=!this.showCompras
  }

  ngOnInit(){
    this.loginService.getUserStats(this.loginService.id,
      (data)=>{
        this.userStats=data;
      })
  }
  protected readonly filtrosBusquedaCompra = filtrosBusquedaCompra;
  protected readonly faUser = faUser;
  protected readonly faExpand = faExpand;
  protected readonly faDownLong = faDownLong;
  protected readonly faUpLong = faUpLong;
}
