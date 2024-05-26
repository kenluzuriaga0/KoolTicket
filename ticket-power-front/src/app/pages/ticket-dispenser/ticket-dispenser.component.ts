import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ticket-dispenser',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ticket-dispenser.component.html',
  styleUrl: './ticket-dispenser.component.css'
})
export class TicketDispenserComponent {
  buttons = ['CITAS MEDICAS', 'INFORMACIÓN', 'LABORATORIO', 'PRUEBAS COVID','OTROS SERVICIOS', 'DERIVACIONES']

}
