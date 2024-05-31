export class UserStats {
  "id": String
  "compras": Number
  "ventas": Number
  "calificacionMedia": Number
  "reviewsRecibidas": Number

  constructor(){
    return {
      "id": "",
      "compras": 0,
      "ventas": 0,
      "calificacionMedia": 0,
      "reviewsRecibidas":0
    }
  }
}
