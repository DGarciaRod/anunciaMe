import {Component, Input} from '@angular/core';
import {RouterLink} from "@angular/router";
import {faCircle, faUser} from "@fortawesome/free-solid-svg-icons";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {IconDefinition} from "@fortawesome/fontawesome-svg-core";

@Component({
  selector: 'app-nav-bar-button',
  standalone: true,
  imports: [RouterLink, FaIconComponent],
  templateUrl: './nav-bar-button.component.html',
  styleUrl: './nav-bar-button.component.css'
})
export class NavBarButtonComponent {
@Input() url: string="";
  @Input() name: string="";
  @Input() icon:IconDefinition = faCircle

  protected readonly faUser = faUser;
}
