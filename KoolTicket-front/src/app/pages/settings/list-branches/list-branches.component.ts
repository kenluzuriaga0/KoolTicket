import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-list-branches',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './list-branches.component.html',
  styleUrl: './list-branches.component.css'
})
export class ListBranchesComponent {

}
