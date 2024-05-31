import {Routes} from '@angular/router';
import {AuthPanelComponent} from "./pages/auth-panel/auth-panel.component";
import {RegisterPanelComponent} from "./pages/auth-panel/register-panel/register-panel.component";
import {LoginPanelComponent} from "./pages/auth-panel/login-panel/login-panel.component";
import {MainPageComponent} from "./pages/main-page/main-page.component";
import {logedGuard} from "./pages/main-page/loged.guard";
import {notLogedGuard} from "./pages/main-page/not-loged.guard";
import {UsrPageComponent} from "./pages/main-page/mainPages/usr-page/usr-page.component";
import {CrearAnuncioComponent} from "./pages/main-page/mainPages/anuncios/crear-anuncio/crear-anuncio.component";
import {BuscarAnunciosComponent} from "./pages/main-page/mainPages/anuncios/buscar-anuncios/buscar-anuncios.component";
import {VerAnuncioComponent} from "./pages/main-page/mainPages/anuncios/ver-anuncio/ver-anuncio.component";
import {VerCompraComponent} from "./pages/main-page/mainPages/compras/ver-compra/ver-compra.component";

export const routes: Routes = [
  {
    path: "auth", component: AuthPanelComponent,
    children: [
      {path: 'login', component: LoginPanelComponent},
      {path: 'registro', component: RegisterPanelComponent}
    ], canActivateChild: [notLogedGuard], canActivate: [notLogedGuard]
  },
  {path: "home", component: MainPageComponent, canActivate: [logedGuard],
  children: [
    {path: '', component: BuscarAnunciosComponent},
    {path: 'usuario', component: UsrPageComponent},
    {path: 'crearAnuncio', component: CrearAnuncioComponent},
    {path: 'anuncio/:id', component: VerAnuncioComponent},
    {path: 'compra/:id', component: VerCompraComponent},
  ]},
  {path: "", redirectTo: "/auth/login", pathMatch: 'full'},
]
