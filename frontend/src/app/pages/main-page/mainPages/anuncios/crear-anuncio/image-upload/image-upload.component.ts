import {Component, ElementRef, Input, ViewChild} from '@angular/core';
import {InputButtonComponent} from "../../../../../../components/common/input-button/input-button.component";
import {NgForOf, NgIf} from "@angular/common";
import {faCircleExclamation, faCloud, faTrash, faUpload} from "@fortawesome/free-solid-svg-icons";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-image-upload',
  standalone: true,
  imports: [
    InputButtonComponent,
    NgForOf,
    FaIconComponent,
    NgIf
  ],
  templateUrl: './image-upload.component.html',
  styleUrl: './image-upload.component.css'
})
export class ImageUploadComponent {
  uploadedImages:String[]=[]
  // @ts-ignore
  @ViewChild('fileUpload') fileUploadRef: HTMLInputElement;
// @ts-ignore
  @Input() formGroup:FormGroup;
  @Input() setImags:(a:any)=>any=()=>{};
  convertBase64 = (file:File) => {
    return new Promise((resolve, reject) => {
      const fileReader = new FileReader();
      fileReader.readAsDataURL(file);

      fileReader.onload = () => {
        resolve(fileReader.result);
      };

      fileReader.onerror = (error) => {
        reject(error);
      };
    });
  };
  async onFileSelected(event:any){
    console.log(event.target.files[0])
    for(let i=0;i<event.target.files.length;i++){
      const base64:any = await this.convertBase64(event.target.files[i]);
      const base64Str : String = base64
      this.uploadedImages.push(base64Str)
    }
    this.setImags(this.uploadedImages)
  }

  deleteImage(index:number){
    this.uploadedImages=this.uploadedImages.slice(0,index).concat(this.uploadedImages.slice(index+1))
    this.setImags(this.uploadedImages)
  }

  uploadImage=(a:any)=>{
    return false
  }

  protected readonly faCircleExclamation = faCircleExclamation;
  protected readonly faTrash = faTrash;
  protected readonly faCloud = faCloud;
  protected readonly faUpload = faUpload;
}


