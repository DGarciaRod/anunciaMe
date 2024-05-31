import {Component, EventEmitter, inject, Input, Output} from '@angular/core';
import {ReviewStarsComponent} from "../review-stars/review-stars.component";
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {SimpleFormComponent} from "../common/simple-form/simple-form.component";
import {InputTextareaComponent} from "../common/input-textarea/input-textarea.component";
import {InputButtonComponent} from "../common/input-button/input-button.component";
import {AnunciosService} from "../../services/anuncios.service";
import {Review} from "../../model/Review";

@Component({
  selector: 'app-review-form',
  standalone: true,
  imports: [
    ReviewStarsComponent,
    SimpleFormComponent,
    InputTextareaComponent,
    InputButtonComponent,
    ReactiveFormsModule
  ],
  templateUrl: './review-form.component.html',
  styleUrl: './review-form.component.css'
})
export class ReviewFormComponent {
  reviewForm = this.formBuilder.group({
    puntuacion: [3, Validators.required],
    descripcion: ['', Validators.required],
  });
  anuncioService = inject(AnunciosService)
  @Input() compra:String=""
  @Output() reviewEmitter = new EventEmitter<Review>()
  hacerReview=()=>{
    if(!this.reviewForm.value.puntuacion || !this.reviewForm.value.descripcion)
      return
    this.anuncioService.hacerReview(this.compra,
      this.reviewForm.value.puntuacion,
      this.reviewForm.value.descripcion,
      (data)=>{
        this.reviewEmitter.emit(data)
      })
  }
  setPuntuacion=(puntuacion:Number)=>{
    this.reviewForm.controls.puntuacion.setValue(puntuacion.valueOf())
  }

  constructor(private formBuilder: FormBuilder) {}
}
