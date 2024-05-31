import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Subscription} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class FetchService {
  http = inject(HttpClient)

  private getHeaders(){
    let headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
      'token': ''
    }
    const token = localStorage.getItem("token")
    if(token)
      headerDict={...headerDict, "token": token}

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return requestOptions
  }

  get(route: string, onSuccess?: (data:any) => any, onErrors?: (errorData:any) => any):Subscription{
    return this.http.get(environment.dbUrl+route, this.getHeaders()).subscribe(
      (data)=>{
        onSuccess&&onSuccess(data)
      },
      (errorData)=>{
        onErrors&&onErrors(errorData)
      }
    )
  }

  post(route: string, body:any , onSuccess?: (data:any) => any, onErrors?: (errorData:any) => any):Subscription{
    return this.http.post(environment.dbUrl+route, body, this.getHeaders()).subscribe(
      (data)=>{
        onSuccess&&onSuccess(data)
      },
      (errorData)=>{
        onErrors&&onErrors(errorData)
      }
    )
  }
  constructor() { }
}
