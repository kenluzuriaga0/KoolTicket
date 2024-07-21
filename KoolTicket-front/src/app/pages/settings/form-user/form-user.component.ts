import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { UserService } from '../../../services/user.service';
import { Usuario } from '../../../core/domain';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-user',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './form-user.component.html',
  styleUrl: './form-user.component.css'
})
export class FormUserComponent implements OnInit {
  
  _user:UserService = inject(UserService);
  _router = inject(ActivatedRoute)
  user:Usuario = {} as Usuario;

  ngOnInit(): void {
    if(this._router.snapshot.params['id']){
      this._user.getOneById(this._router.snapshot.params['id']).subscribe((data:any)=>{
        this.user = data;
      });
    }
  }

}
