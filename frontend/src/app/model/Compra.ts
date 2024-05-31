export class Compra{
  "id": String
  "anuncio": String
  "cantidad": Number
  "precioPagadoPorArticulo": Number
  "comprador": String
  'fecha': Date
  constructor() {
    return{
      id: "",
      anuncio: "",
      cantidad: 0,
      precioPagadoPorArticulo: 0,
      comprador: "",
      fecha: new Date(),
    }
  }
}
