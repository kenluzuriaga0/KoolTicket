import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ticket-dispenser',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ticket-dispenser.component.html',
  styleUrl: './ticket-dispenser.component.css'
})
export class TicketDispenserComponent implements OnInit {

  classGrid = 'grid grid-cols-2 gap-4';  // Por defecto 2 columnas 
  buttons = ['CITAS MEDICAS', 'INFORMACIÓN', 'LABORATORIO', 'PRUEBAS COVID', 'OTROS SERVICIOS', 'DERIVACIONES']

  ngOnInit(): void {
    if (this.buttons.length < 4) {  // Si son menos de 4, es 1 columna
      this.classGrid = 'grid grid-cols-1'
    }
  }

}
