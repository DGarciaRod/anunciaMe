import {CanActivateFn, GuardResult, Router} from '@angular/router';
import {inject} from "@angular/core";
import {LoginService} from "../../services/login.service";

export const notLogedGuard: CanActivateFn = (route, state) => {
  const loginService = inject(LoginService)
  const router = inject(Router)
  const token = localStorage.getItem("token")
  if(!token)
    return true
  else {
    router.navigate(["/home"])
    return loginService.loginFromTokenInLocalStorage(true)
  }
};
