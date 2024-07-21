import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Usuario } from '../../../core/domain';
import { UserService } from '../../../services/user.service';

@Component({
  selector: 'app-list-users',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './list-users.component.html',
  styleUrl: './list-users.component.css'
})
export class ListUsersComponent {

  _user = inject(UserService);
  users:Usuario[] = [];

  ngOnInit(): void {
    this._user.getAllUsers().subscribe((data:any)=>{
        this.users = data;
    });
  }

}
