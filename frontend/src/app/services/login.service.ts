import {inject, Injectable, Optional} from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {GuardResult, Router} from "@angular/router";
import {catchError, map, Observable} from "rxjs";
import {FetchService} from "./fetch.service";
import {Usuario} from "../model/Usuario";
import {UserStats} from "../model/UserStats";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  loged = false
  token = ""
  id = ""
  usuario = ""
  nombre = ""
  http = inject(HttpClient)
  router = inject(Router);
  fetchService = inject(FetchService)

  saveTokenInLocalStorage(token:string){
    localStorage.setItem("token", token)
  }
  setUserInfo(fetchedData: any){
    this.id = fetchedData.id
    this.token = fetchedData.token
    this.nombre = fetchedData.nombre
    this.usuario = fetchedData.usuario
  }

  login(userName: string, pass: string, onSuccess?: () => any, onErrors?: () => any) {
    this.fetchService.post("/api/usuarios/login", {
      usuario: userName,
      pass: pass
    }, (data)=>{
      this.saveTokenInLocalStorage(data.token)
      this.setUserInfo(data)
      this.loged = true
      onSuccess && onSuccess()
    }, (errorData)=>{
      this.token = ""
      this.loged = false
      onErrors&&onErrors()
    })
  }



  loginFromTokenInLocalStorage(invert?: boolean): Observable<GuardResult> {
    return this.http.post(environment.dbUrl+"/api/usuarios/loginFromToken", {
      token: localStorage.getItem("token")
    }).pipe(
      map((data: any) => {
        if (data) {
          this.token = data.token
          this.nombre = data.nombre
          this.usuario = data.usuario
          this.id = data.id
          this.loged = true
          return !invert
        } else {
          return !!invert
        }

      }), catchError(
        (a:any, b:Observable<boolean>)=>{
          localStorage.clear()
          this.router.navigate(["/auth/login"])
          throw Error;
        }
      )
    )
  }

  register(name: string, userName: string, pass: string, onSuccess?: (data:any) => any, onErrors?: (errorData:any) => any) {
    this.fetchService.post("/api/usuarios/register", {
      nombre: name,
      usuario: userName,
      pass: pass
    }, (data)=>{
      this.saveTokenInLocalStorage(data.token)
      this.setUserInfo(data)
      this.loged = true
      onSuccess && onSuccess(data)
    }, (errorData)=>{
      this.token = ""
      this.loged = false
      onErrors && onErrors(errorData)
    })
  }
  logout() {
    this.token = ""
    this.loged = false
    this.usuario = ""
    this.nombre = ""
    this.id=""
    localStorage.clear()
    this.router.navigate(["/auth/login"])
  }

  getUserInfo(id: String, onSuccess?: (data:Usuario) => any){
    this.fetchService.get("/api/usuarios/"+id, (data:Usuario)=>{
      onSuccess&&onSuccess(data);
    })
  }

  getUserStats(id: String, onSuccess?: (data:UserStats) => any){
    this.fetchService.get("/api/usuarios/"+id+"/stats", (data:UserStats)=>{
      onSuccess&&onSuccess(data);
    })
  }


  constructor() {
    let actToken = localStorage.getItem("token")
  }
}
