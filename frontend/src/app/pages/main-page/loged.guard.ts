import {CanActivateFn, GuardResult, Router} from '@angular/router';
import {inject} from "@angular/core";
import {LoginService} from "../../services/login.service";
import {map, Observable} from "rxjs";

export const logedGuard: CanActivateFn = (route, state) => {
  const loginService = inject(LoginService)
  const router = inject(Router)
  const token = localStorage.getItem("token")
  if(!token) {
    router.navigate(["/auth/login"])
    return false
  }
  return  loginService.loginFromTokenInLocalStorage()
};

