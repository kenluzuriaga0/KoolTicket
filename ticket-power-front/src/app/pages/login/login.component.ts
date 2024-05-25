import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { SelectBranchComponent } from '../select-branch/select-branch.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, RouterLink, ReactiveFormsModule, RouterOutlet, RouterLinkActive],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  formlogin: FormGroup = new FormGroup({});

  constructor(
    private router:Router) { }

    ngOnInit(): void {
      this.formlogin = new FormGroup(
        {
        username: new FormControl('',[ //validaciones
          Validators.required,
        ]), 
        password: new FormControl('')
      });
    }

    
  formSubmit(){
    this.router.navigate(['branch']) 
  }
}
