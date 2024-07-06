import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SideBarComponent } from '../../../components/side-bar/side-bar.component';
import { TicketDispenserComponent } from '../ticket-dispenser/ticket-dispenser.component';
import { TicketWaitListComponent } from '../ticket-wait-list/ticket-wait-list.component';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-ticket-call',
  standalone: true,
  imports: [CommonModule, SideBarComponent, RouterLink,TicketDispenserComponent, TicketWaitListComponent, RouterOutlet],
  templateUrl: './ticket-call.component.html',
  styleUrl: './ticket-call.component.css'
})
export class TicketCallComponent {

}
