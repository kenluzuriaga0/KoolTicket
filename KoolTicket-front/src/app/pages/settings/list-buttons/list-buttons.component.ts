import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ButtonService } from '../../../services/button.service';
import { Boton } from '../../../core/domain';

@Component({
  selector: 'app-list-buttons',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './list-buttons.component.html',
  styleUrl: './list-buttons.component.css'
})
export class ListButtonsComponent {

  _button:ButtonService = inject(ButtonService);
  buttons:Boton[] = [];

  ngOnInit(): void {
    this._button.getAllButtons().subscribe((data:any)=>{
        this.buttons = data;
    });
  }
}
