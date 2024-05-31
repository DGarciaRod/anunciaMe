import {Component, inject, Input} from '@angular/core';
import {Compra} from "../../../../../model/Compra";
import {NgForOf, NgIf} from "@angular/common";
import {AnunciosService, filtrosBusquedaCompra} from "../../../../../services/anuncios.service";
import {ListarComprasRowComponent} from "./listar-compras-row/listar-compras-row.component";
import {
  PrevAndNextPageComponent
} from "../../../../../components/common/prev-and-next-page/prev-and-next-page.component";
import {LoginService} from "../../../../../services/login.service";

@Component({
  selector: 'app-listar-compras',
  standalone: true,
  imports: [
    NgForOf,
    ListarComprasRowComponent,
    NgIf,
    PrevAndNextPageComponent
  ],
  templateUrl: './listar-compras.component.html',
  styleUrl: './listar-compras.component.css'
})
export class ListarComprasComponent {
  @Input() tipo:filtrosBusquedaCompra=filtrosBusquedaCompra.comprador;
  @Input() anuncioId:String=""
  protected readonly filtrosBusquedaCompra = filtrosBusquedaCompra;
  anunciosService=inject(AnunciosService)
  loginService=inject(LoginService)
  compras:Compra[]=[]
  existMore:boolean=false
  id:String=""
  searchParams={
    "pageNum":0,
  }
  prevPage=()=>{
    this.searchParams.pageNum--;
    this.anunciosService.obtenerCompras(this.id, this.tipo, this.searchParams.pageNum, (data)=> {
      this.compras = data.items
      this.existMore=data.existMoreItems
    })
  }
  nextPage= ()=>{
    this.searchParams.pageNum++;
    this.anunciosService.obtenerCompras(this.id, this.tipo, this.searchParams.pageNum, (data)=> {
      this.compras = data.items
      this.existMore=data.existMoreItems
    })
  }
  ngOnInit(){
    if(this.tipo==filtrosBusquedaCompra.comprador || this.tipo==filtrosBusquedaCompra.vendedor)
      this.id=this.loginService.id;
    if(this.tipo==filtrosBusquedaCompra.anuncio)
      this.id=this.anuncioId;
    this.anunciosService.obtenerCompras(this.id, this.tipo, 0, (data)=> {
      this.compras = data.items
      this.existMore=data.existMoreItems
    })
  }
  foo(){}
}
