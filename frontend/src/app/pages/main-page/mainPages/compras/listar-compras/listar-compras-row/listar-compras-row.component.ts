import {Component, inject, Input} from '@angular/core';
import {AnunciosService, filtrosBusquedaCompra} from "../../../../../../services/anuncios.service";
import {Anuncio} from "../../../../../../model/Anuncio";
import {Compra} from "../../../../../../model/Compra";
import {Router} from "@angular/router";
import {Usuario} from "../../../../../../model/Usuario";
import {LoginService} from "../../../../../../services/login.service";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-listar-compras-row',
  standalone: true,
  imports: [
    NgIf
  ],
  templateUrl: './listar-compras-row.component.html',
  styleUrl: './listar-compras-row.component.css'
})
export class ListarComprasRowComponent {
  @Input() compra:Compra=new Compra();
  @Input() tipo:filtrosBusquedaCompra=filtrosBusquedaCompra.comprador
  router = inject(Router)
  anuncuoService=inject(AnunciosService)
  loginService=inject(LoginService)
  anuncio:Anuncio=new Anuncio();
  comprador:Usuario=new Usuario();
  ngOnInit(){
    this.anuncuoService.obtenerAnuncio(this.compra.anuncio, (data)=>{this.anuncio=data})
    this.loginService.getUserInfo(this.compra.comprador, (data)=>{this.comprador=data})
  }
  goToCompra(){
    this.router.navigate(["/home/compra/"+this.compra.id])
    return false
  }

  protected readonly filtrosBusquedaCompra = filtrosBusquedaCompra;
}
