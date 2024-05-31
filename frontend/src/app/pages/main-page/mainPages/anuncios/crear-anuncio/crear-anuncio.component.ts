import {Component, inject} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {InputFieldComponent} from "../../../../../components/common/input-field/input-field.component";
import {InputButtonComponent} from "../../../../../components/common/input-button/input-button.component";
import {SimpleFormComponent} from "../../../../../components/common/simple-form/simple-form.component";
import {InputTextareaComponent} from "../../../../../components/common/input-textarea/input-textarea.component";
import {InputSelectComponent} from "../../../../../components/common/input-select/input-select.component";
import {AnunciosService} from "../../../../../services/anuncios.service";
import {Router} from "@angular/router";
import {InputPrecioComponent} from "../../../../../components/common/input-precio/input-precio.component";
import {ImageUploadComponent} from "./image-upload/image-upload.component";
import {PanelTitleComponent} from "../../../../../components/common/panel-title/panel-title.component";
import {NgIf} from "@angular/common";
import {CrearAnuncioFormType} from "./crearAnuncioFormType";

@Component({
  selector: 'app-crear-anuncio',
  standalone: true,
  imports: [
    InputFieldComponent,
    InputButtonComponent,
    SimpleFormComponent,
    InputTextareaComponent,
    InputSelectComponent,
    InputPrecioComponent,
    ImageUploadComponent,
    PanelTitleComponent,
    NgIf
  ],
  templateUrl: './crear-anuncio.component.html',
  styleUrl: './crear-anuncio.component.css'
})



export class CrearAnuncioComponent {
  router = inject(Router)
  anuncioService = inject(AnunciosService)



 crearAnuncioForm: FormGroup<CrearAnuncioFormType> = new FormGroup<CrearAnuncioFormType>({
  descripcion: new FormControl('', {nonNullable: true}),
  nombre: new FormControl('', {nonNullable: true}),
  categoria: new FormControl('', {nonNullable: true}),
  precio: new FormControl(1.0, {nonNullable: true}),
  imagenes: new FormControl([], {nonNullable: true}),
});

  crearAnuncioForm2 = this.formBuilder.group({
    descripcion: ['', Validators.required],
    nombre: ['', Validators.required],
    categoria: ['', Validators.required],
    precio: [1.0, Validators.required],
    imagenes: [[]]
  });
  globalError = false
  valErrors = {}
  fieldErrors = {
    nombre: false,
    descripcion: false,
    categoria: false
  }

  resetFieldErrors() {
    this.fieldErrors.nombre = false
    this.fieldErrors.descripcion = false
    this.fieldErrors.categoria = false
  }


  crearAnuncio = () => {
    let nombre = this.crearAnuncioForm.value.nombre
    let descripcion = this.crearAnuncioForm.value.descripcion
    let categoria = this.crearAnuncioForm.value.categoria
    let precio = this.crearAnuncioForm.value.precio
    let imagenes = this.crearAnuncioForm.value.imagenes
    console.log(imagenes)
    if (nombre && descripcion && categoria && precio) {
      this.anuncioService.crearAnuncio(nombre, descripcion, categoria, precio, imagenes,
        (data)=>{
          this.router.navigate(["/home/anuncio/"+data.id])
        })

    }
  }

  setImages=(imgs: String[])=>{
    console.log("img set " + imgs.length.toString())
    // @ts-ignore
    this.crearAnuncioForm.value.imagenes=imgs;
  }

  constructor(private formBuilder: FormBuilder) {}
}
