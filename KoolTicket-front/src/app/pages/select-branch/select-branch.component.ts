import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-select-branch',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './select-branch.component.html',
  styleUrl: './select-branch.component.css'
})
export class SelectBranchComponent {

  branch_offices = [
    {'name': 'Sucursal 1', 'address': 'Dirección Sucursal 1'},
    {'name': 'Sucursal 2', 'address': 'Dirección Sucursal 2'},
    {'name': 'Sucursal 3', 'address': 'Dirección Sucursal 3'},
    {'name': 'Sucursal 4', 'address': 'Dirección Sucursal 4'},
  ];

}
