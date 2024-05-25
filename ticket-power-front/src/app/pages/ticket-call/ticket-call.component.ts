import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SideBarComponent } from '../../components/side-bar/side-bar.component';

@Component({
  selector: 'app-ticket-call',
  standalone: true,
  imports: [CommonModule, SideBarComponent],
  templateUrl: './ticket-call.component.html',
  styleUrl: './ticket-call.component.css'
})
export class TicketCallComponent {

}
