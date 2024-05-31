export class Anuncio {
  "id": String
  "nombre": String
  "descripcion": String
  "categoria": String
  "vendedor": String
  "precio": Number
  "imagenes": String[]
  "categoriaId": String
  "vendedorId": String



  constructor() {
    return {
      id: "",
      nombre: "",
      descripcion: "",
      categoria: "",
      vendedor: "",
      precio: 0,
      imagenes: [],
      categoriaId: "",
      vendedorId: "",
    }

  }
}
