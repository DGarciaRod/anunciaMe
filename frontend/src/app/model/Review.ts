export class Review {
  "id": String
  "compra": String
  "calificacion": Number
  "mensaje": String
  "comprador": String

  constructor() {
    return {
      "id": "",
      "compra": "",
      "calificacion": 0,
      "mensaje": "",
      "comprador": ""
    }
  }
}

export class GetReviewResponse{
  "done":boolean;
  "review":Review;
}
