import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ticket-wait-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ticket-wait-list.component.html',
  styleUrl: './ticket-wait-list.component.css'
})
export class TicketWaitListComponent {
  lista = [
    {name: 'Turno L1', caja: 'Caja 2'},
    {name: 'Turno C2', caja: 'Caja 1'},
    {name: 'Turno C3', caja: 'Caja 4'},
    {name: 'Turno C4', caja: 'Caja 3'},
    {name: 'Turno C5', caja: 'Caja 2'},
    {name: 'Turno C6', caja: 'Caja 1'},
    {name: 'Turno C7', caja: 'Caja 1'},
    {name: 'Turno C8', caja: 'Caja 1'},
    {name: 'Turno C9', caja: 'Caja 4'},
    {name: 'Turno C7', caja: 'Caja 1'},
    {name: 'Turno C7', caja: 'Caja 1'},

  ]
}
