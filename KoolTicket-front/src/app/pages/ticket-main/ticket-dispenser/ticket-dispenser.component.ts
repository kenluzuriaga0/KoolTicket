import { Component, inject, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Boton } from '../../../core/domain';
import { ButtonService } from '../../../services/button.service';
import {NgxPrintModule, NgxPrintService, PrintOptions} from 'ngx-print';

@Component({
  selector: 'app-ticket-dispenser',
  standalone: true,
  imports: [CommonModule, NgxPrintModule],
  templateUrl: './ticket-dispenser.component.html',
  styleUrl: './ticket-dispenser.component.css'
})
export class TicketDispenserComponent implements OnInit {

  classGrid = 'grid grid-cols-2 gap-4';  // Por defecto 2 columnas 
  // buttons = ['CITAS MEDICAS', 'INFORMACIÓN', 'LABORATORIO', 'PRUEBAS COVID', 'OTROS SERVICIOS', 'DERIVACIONES']
  _button:ButtonService = inject(ButtonService);
  _print:NgxPrintService = inject(NgxPrintService);
  buttons:Boton[] = [];

  btnCurrent = signal<Boton | null>(null);


  ngOnInit(): void {
   
    this._button.getAllButtons().subscribe((data:any)=>{
      this.buttons = data;
      this.buttons = this.buttons.filter(b=>b.estado==true);
      if (this.buttons.length < 4) {  // Si son menos de 4, es 1 columna
        this.classGrid = 'grid grid-cols-1'
      }
  });
  }


  setBtnCurrent(btn:Boton) {
    this.btnCurrent.set(btn);  // TODO: Mejorar impresion de ticket actual
    console.log(this.btnCurrent());
  }

}
