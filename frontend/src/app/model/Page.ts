export class Page<t> {
  "existMoreItems": boolean
  "items": t[]

  constructor() {
    return{
      "existMoreItems": false,
      "items": []
    }
  }
}
