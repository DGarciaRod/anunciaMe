import {Component, inject} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-check-login',
  standalone: true,
  imports: [],
  templateUrl: './check-login.component.html',
  styleUrl: './check-login.component.css'
})
export class CheckLoginComponent {
  loginChecked = false
  isLoged = false
  http=inject(HttpClient)
  checkLog(){
    let token=localStorage.getItem("token")
    if(!token) {
      this.loginChecked=true
      return
    }else{
      this.http.post("http://localhost:8080/usuarios/loginFromToken", {
        token: token
      }).subscribe((data:any)=> {
        console.log(data)
      })
    }

  }
}
