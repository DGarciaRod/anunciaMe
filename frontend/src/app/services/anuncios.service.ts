import {inject, Injectable} from '@angular/core';
import {FetchService} from "./fetch.service";
import {Compra} from "../model/Compra";
import {Anuncio} from "../model/Anuncio";
import {Page} from "../model/Page";
import {GetReviewResponse, Review} from "../model/Review";
import {UserStats} from "../model/UserStats";
import {AnuncioStats} from "../model/AnuncioStats";


export enum filtrosBusquedaCompra{
  vendedor="porVendedor",
  comprador="porComprador",
  anuncio="porAnuncio",
}
@Injectable({
  providedIn: 'root'
})

export class AnunciosService {
  fetchService = inject(FetchService)
  busquedaActual: any[] = []
  hayMas = false
  categorias: any[] = []

  crearAnuncio(nombre: String, descripcion: String, categoria: String, precio: Number, imagenes?: String[], onSuccess?: (data: any) => any, onErrors?: (errorData: any) => any) {
    this.fetchService.post("/api/anuncios/crear",
      {
        "nombre": nombre,
        "descripcion": descripcion,
        "categoria": categoria,
        "precio": precio,
        "imagenes": imagenes,
      },
      (data) => {
        onSuccess && onSuccess(data)
      },
      (errorData) => {
        onErrors && onErrors(errorData)
      })
  }

  limpiarBusqueda() {
    this.busquedaActual = [];
    this.hayMas = false;
  }

  paramterosBusqueda: {
    texto: String | null, categoria: String | null, minPrice: Number | null, maxPrice: Number | null,
    orderBy: String | null, orderSort: String | null, pageNum: Number | null, pageSize: Number | null
  } = {
    texto: "",
    categoria: "",
    minPrice: null,
    maxPrice: null,
    orderBy: null,
    orderSort: null,
    pageNum: 0,
    pageSize: 5,
  }

  buscarAnuncio(texto: String | null, categoria: String | null, minPrice: Number | null, maxPrice: Number | null,
                orderBy: String | null, orderSort: String | null, pageNum: Number | null, onSuccess?: (data: any) => any, onErrors?: (errorData: any) => any) {
    let route = "/api/anuncios/buscar?"
    if (texto)
      route = route + "&texto=" + texto
    if (categoria)
      route = route + "&categoria=" + categoria
    if (minPrice)
      route = route + "&minPrice=" + minPrice
    if (maxPrice)
      route = route + "&maxPrice=" + maxPrice
    if (orderBy)
      route = route + "&orderBy=" + orderBy
    if (orderSort)
      route = route + "&orderSort=" + orderSort
    if (pageNum)
      route = route + "&pageNumber=" + pageNum
    this.paramterosBusqueda = {
      texto: texto,
      categoria: categoria,
      minPrice: minPrice,
      maxPrice: maxPrice,
      orderBy: orderBy,
      orderSort: orderSort,
      pageNum: pageNum,
      pageSize: this.paramterosBusqueda.pageSize
    }
    this.fetchService.get(route,
      (data) => {
        this.busquedaActual = data.items
        this.hayMas = data.existMoreItems
        onSuccess && onSuccess(data)
      },
      (errorData) => {
        onErrors && onErrors(errorData)
      })
  }

  siguientePagina=(onSuccess?: (data: any) => any, onErrors?: (errorData: any) => any) =>{
    let pb = this.paramterosBusqueda
    console.log(pb)
    this.buscarAnuncio(pb.texto, pb.categoria, pb.minPrice, pb.maxPrice, pb.orderBy, pb.orderSort, pb.pageNum ? pb.pageNum.valueOf() + 1 : 1, onSuccess, onErrors)
  }

  anteriorPagina=(onSuccess?: (data: any) => any, onErrors?: (errorData: any) => any)=> {
    let pb = this.paramterosBusqueda
    this.buscarAnuncio(pb.texto, pb.categoria, pb.minPrice, pb.maxPrice, pb.orderBy, pb.orderSort, pb.pageNum ? pb.pageNum.valueOf() - 1 : null, onSuccess, onErrors)
  }

  obtenerCategorias() {
    this.fetchService.get("/api/anuncios/categorias",
      (data) => {
        let catList = []
        for (var categoria of data) {
          catList.push({name: categoria.nombre, value: categoria.id})
        }
        this.categorias = catList;
      })
  }

  obtenerAnuncio(id: String, onSuccess?: (data: Anuncio) => any, onErrors?: (errorData: any) => any) {
    this.fetchService.get("/api/anuncios/info?id=" + id,
      (data) => {
        onSuccess && onSuccess(data)
      },
      (data) => {
        onErrors && onErrors(data)
      })
  }

  comprar(anuncio: String, cantidad: Number, onSuccess?: (data: any) => any, onErrors?: (errorData: any) => any) {
    this.fetchService.post("/api/anuncios/comprar",
      {
        "anuncio": anuncio,
        "cantidad": cantidad
      },
      (data) => {
        onSuccess && onSuccess(data)
        console.log(data)
      },
      (errorData) => {
        onErrors && onErrors(errorData)
      })
  }

  obtenerCompra(id: String, onSuccess?: (data: Compra) => any, onErrors?: (errorData: any) => any) {
    this.fetchService.get("/api/anuncios/compra/info?id=" + id,
      (data:Compra) => {
        onSuccess && onSuccess(data)
      },
      (data) => {
        onErrors && onErrors(data)
      })
  }


  obtenerCompras(id: String, filtro: filtrosBusquedaCompra, pageNum: Number | null, onSuccess?: (data: Page<Compra>) => any, onErrors?: (errorData: any) => any) {
    let route ="/api/anuncios/compra/"+filtro+"?id=" + id
    if (pageNum)
      route = route + "&pageNumber=" + pageNum
    this.fetchService.get(route,
      (data:Page<Compra>) => {
        onSuccess && onSuccess(data)
      },
      (data) => {
        onErrors && onErrors(data)
      })
  }

  hacerReview(compra: String, calificacion: Number, mensaje: String, onSuccess?: (data: Review) => any, onErrors?: (errorData: any) => any) {
    this.fetchService.post("/api/anuncios/compra/review",
      {
        "compra": compra,
        "calificacion": calificacion,
        "mensaje": mensaje,
      },
      (data:Review) => {
        onSuccess && onSuccess(data)
        console.log(data)
      },
      (errorData) => {
        onErrors && onErrors(errorData)
      })
  }

  obtenerReviewDeCompra(compra: String, onSuccess?: (data: GetReviewResponse) => any, onErrors?: (errorData: any) => any) {
    this.fetchService.get("/api/anuncios/compra/"+compra+"/review",
      (data:GetReviewResponse) => {
        onSuccess && onSuccess(data)
      },
      (errorData) => {
        onErrors && onErrors(errorData)
      })
  }
  obtenerReviewsAnuncio(anuncio: String, pageNum: Number | null ,orderBy: String | null, orderSort: String | null, onSuccess?: (data: Page<Review>) => any, onErrors?: (errorData: any) => any) {
    let route="/api/anuncios/"+anuncio+"/reviews?"
    if (orderBy)
      route = route + "&orderBy=" + orderBy
    if (orderSort)
      route = route + "&orderSort=" + orderSort
    if (pageNum)
      route = route + "&pageNumber=" + pageNum
    this.fetchService.get(route,
      (data:Page<Review>) => {
        onSuccess && onSuccess(data)
      },
      (errorData) => {
        onErrors && onErrors(errorData)
      })
  }

  getAnuncioStats(id: String, onSuccess?: (data:AnuncioStats) => any){
    this.fetchService.get("/api/anuncios/"+id+"/stats", (data:AnuncioStats)=>{
      onSuccess&&onSuccess(data);
    })
  }

  constructor() {
    this.obtenerCategorias()
  }
}
