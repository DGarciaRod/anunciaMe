import {Component, inject} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {FloatingPanelComponent} from "../../../components/floating-panel/floating-panel.component";
import {HttpClient} from "@angular/common/http";
import {LoginService} from "../../../services/login.service";
import {Router} from "@angular/router";
import {InputFieldComponent} from "../../../components/common/input-field/input-field.component";
import {InputButtonComponent} from "../../../components/common/input-button/input-button.component";
import { Validators } from '@angular/forms';
import {NgIf} from "@angular/common";
import { faCircleExclamation } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {SimpleFormComponent} from "../../../components/common/simple-form/simple-form.component";
@Component({
  selector: 'app-login-panel',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FloatingPanelComponent,
    InputFieldComponent,
    InputButtonComponent,
    NgIf,
    FontAwesomeModule,
    SimpleFormComponent
  ],
  templateUrl: './login-panel.component.html',
  styleUrl: './login-panel.component.css'
})
export class LoginPanelComponent {
  http = inject(HttpClient);
  router = inject(Router);
  loginService = inject(LoginService);
  loginForm = this.formBuilder.group({
    username: ['', Validators.required],
    pass: ['', Validators.required]
  });
  errors=false
  icons={
    circleExclamation: faCircleExclamation
  }
  login = () => {
    this.loginService.logout()
    let usr=this.loginForm.value.username
    let pss=this.loginForm.value.pass

    if (usr && pss) {
      this.loginService.login(usr, pss, () => {
        this.router.navigate(["/home"])
      }, ()=>{
        this.errors=true
      })
    }
    return false;
  }

  constructor(private formBuilder: FormBuilder) {
    this.loginForm.valueChanges.subscribe(value=>{
      this.errors=false
    })
  }

  protected readonly faCircleExclamation = faCircleExclamation;
}
