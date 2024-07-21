import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { ToastrService } from 'ngx-toastr';

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
    private router:Router, private _auth:AuthService, private toastr: ToastrService) { }

    ngOnInit(): void {
      this.formlogin = new FormGroup(
        {
        username: new FormControl('',[ //validaciones
          Validators.required,
        ]), 
        password: new FormControl('')
      });
    }

  // ************* INCIO DE SESION ***********
  formSubmit(): void {
    const loginData = this.formlogin.value
    
    if (loginData.username.trim() != '' || loginData.password.trim() != '') {
      this._auth.postCredentials(loginData).subscribe({
        next: (data:any) => {
          this._auth.loginUser(data.token);
          this._auth.getCurrentUser().subscribe((data:any)=>{
            this._auth.setUser(data.id); // seteo el usuario
            this.showSuccess();
            this.router.navigate(['/branch']) // cambio de pagina
          })
        },
        error: error =>{ 
          this.showError('Digite credenciales válidas')
          this._auth.logout();
        }
      });
    } else {
      this.showError('Lleno los campos de login');
    }
  }

  showSuccess() {
    this.toastr.success('Éxito', 'Inicio de sesion con éxito');
  }
  showError(error) {
    this.toastr.error(error, 'Error');
  }
    
}
