import {Component, inject} from '@angular/core';
import {FloatingPanelComponent} from "../../../components/floating-panel/floating-panel.component";
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {InputFieldComponent} from "../../../components/common/input-field/input-field.component";
import {InputButtonComponent} from "../../../components/common/input-button/input-button.component";
import {LoginService} from "../../../services/login.service";
import {Router} from "@angular/router";
import {faCircleExclamation} from "@fortawesome/free-solid-svg-icons";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {NgIf} from "@angular/common";
import {SimpleFormComponent} from "../../../components/common/simple-form/simple-form.component";

@Component({
  selector: 'app-register-panel',
  standalone: true,
  imports: [
    FloatingPanelComponent,
    ReactiveFormsModule,
    InputFieldComponent,
    InputButtonComponent,
    FaIconComponent,
    NgIf,
    SimpleFormComponent
  ],
  templateUrl: './register-panel.component.html',
  styleUrl: './register-panel.component.css'
})
export class RegisterPanelComponent {
  loginService = inject(LoginService)
  router = inject(Router);

  registerForm = this.formBuilder.group({
    username: ['', Validators.required],
    pass: ['', Validators.required],
    nombre: ['', Validators.required]
  });
  globalError = false
  valErrors = {
    usrAlreadyExists: false
  }
  fieldErrors = {
    username: false
  }

  icons = {
    circleExclamation: faCircleExclamation
  }
  resetValErrors(){
    this.valErrors.usrAlreadyExists=false
  }
  resetFieldErrors(){
    this.fieldErrors.username=false
  }
  register = () => {
    let usr = this.registerForm.value.username
    let pss = this.registerForm.value.pass
    let name = this.registerForm.value.nombre
    if (usr && pss && name) {
      this.loginService.register(name, usr, pss,
        () => {
          this.router.navigate(["/home"])
          return false
        },
        (errorData) => {
          if (errorData.error.code) {
            this.valErrors.usrAlreadyExists = true
            this.fieldErrors.username = true
          }
          else
            this.globalError = true
          return false
        }
      )
    }
    return false;

  }

  constructor(private formBuilder: FormBuilder) {
    this.registerForm.valueChanges.subscribe(value => {
      this.globalError = false
      this.resetValErrors()
      this.resetFieldErrors()
    })
  }

  protected readonly name = name;
  protected readonly faCircleExclamation = faCircleExclamation;
}
