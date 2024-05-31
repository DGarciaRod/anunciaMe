import {Component, inject, Inject} from '@angular/core';
import {InputFieldComponent} from "../../../../../../components/common/input-field/input-field.component";
import {SimpleFormComponent} from "../../../../../../components/common/simple-form/simple-form.component";
import {FormBuilder, FormsModule} from "@angular/forms";
import {InputButtonComponent} from "../../../../../../components/common/input-button/input-button.component";
import {AnunciosService} from "../../../../../../services/anuncios.service";
import {InputSelectComponent} from "../../../../../../components/common/input-select/input-select.component";

@Component({
  selector: 'app-buscador',
  standalone: true,
  imports: [
    InputFieldComponent,
    SimpleFormComponent,
    FormsModule,
    InputButtonComponent,
    InputSelectComponent
  ],
  templateUrl: './buscador.component.html',
  styleUrl: './buscador.component.css'
})
export class BuscadorComponent {
  buscarAnunciosForm=this.formBuilder.group({
    texto: [null],
    categoria: "",
    precio: "",
    orderBy:"precio",
    sortOrder:"asc",
  })
  anuncioService = inject(AnunciosService)

  RangoPrecios=[
    {name:"0€ - 50€", value: 0,min: 0, max:50},
    {name:"50€ - 100€", value: 1,min: 50, max:100},
    {name:"100€ - 500€", value: 2,min: 100, max:500},
    {name:"> 500€", value: 3,min: 500, max: null},
  ]

  camposParaOrdenar=[
    {name:"Precio", value: "precio"},
    {name:"Nombre", value:"nombre"},
    {name:"Categoría", value: "categoria"},
  ]

  ordenOrder=[
    {name:"Asc", value: "asc"},
    {name:"Desc", value:"desc"},
  ]

  buscar=()=>{
    const texto = this.buscarAnunciosForm.value.texto
    const categoria = this.buscarAnunciosForm.value.categoria
    const rangoPrecio = this.buscarAnunciosForm.value.precio
    let minPrice:Number|null=null;
    let maxPrice:Number|null=null;
    if(!!rangoPrecio){
      minPrice=this.RangoPrecios[parseFloat(rangoPrecio)].min
      maxPrice=this.RangoPrecios[parseFloat(rangoPrecio)].max
    }
    const orderBy = this.buscarAnunciosForm.value.orderBy
    const sortOrder = this.buscarAnunciosForm.value.sortOrder
    this.anuncioService.buscarAnuncio(texto?texto:null, categoria?categoria:null,
      minPrice?minPrice:null,maxPrice?maxPrice:null, orderBy?orderBy:null,
      sortOrder?sortOrder:null, 0,
      (data)=>{
      })
    return false;
  }

  constructor(private formBuilder: FormBuilder) {
  }
}
