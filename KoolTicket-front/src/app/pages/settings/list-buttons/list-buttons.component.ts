import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-list-buttons',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './list-buttons.component.html',
  styleUrl: './list-buttons.component.css'
})
export class ListButtonsComponent {

}
