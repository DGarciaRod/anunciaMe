import {Component, inject, Input} from '@angular/core';
import {InputButtonComponent} from "../../../../../../components/common/input-button/input-button.component";
import {FormBuilder, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {SimpleFormComponent} from "../../../../../../components/common/simple-form/simple-form.component";
import {InputPrecioComponent} from "../../../../../../components/common/input-precio/input-precio.component";
import {LoginService} from "../../../../../../services/login.service";
import {AnunciosService} from "../../../../../../services/anuncios.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-comprar-anuncio',
  standalone: true,
  imports: [
    InputButtonComponent,
    SimpleFormComponent,
    InputPrecioComponent,
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './comprar-anuncio.component.html',
  styleUrl: './comprar-anuncio.component.css'
})
export class ComprarAnuncioComponent {
  comprarForm = this.formBuilder.group({
    cantidad: [1, Validators.min(1)]
  });
  @Input() anuncioId:String="";
  router =inject(Router)
  anuncioService = inject(AnunciosService)
  Comprar=()=>{
    const cantidad = this.comprarForm.value.cantidad
    if(cantidad)
    this.anuncioService.comprar(this.anuncioId, cantidad, (data)=>{this.router.navigate(["/home/compra/"+data.id])})
  }
  constructor(private formBuilder: FormBuilder) {}
}
