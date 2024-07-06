import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-form-branch',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './form-branch.component.html',
  styleUrl: './form-branch.component.css'
})
export class FormBranchComponent {

}
