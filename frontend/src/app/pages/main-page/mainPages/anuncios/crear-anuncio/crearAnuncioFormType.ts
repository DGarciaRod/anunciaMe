import {FormControl} from "@angular/forms";

export class CrearAnuncioFormType {
  descripcion: FormControl<string>;
  nombre: FormControl<string>;
  categoria: FormControl<string>;
  precio: FormControl<number>;
  imagenes: FormControl<string[]>;


  constructor(descripcion: FormControl<string>, nombre: FormControl<string>, categoria: FormControl<string>, precio: FormControl<number>, imagenes: FormControl<string[]>) {
    this.descripcion = descripcion;
    this.nombre = nombre;
    this.categoria = categoria;
    this.precio = precio;
    this.imagenes = imagenes;
  }
}
