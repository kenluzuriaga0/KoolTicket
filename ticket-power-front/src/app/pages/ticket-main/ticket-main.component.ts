import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SideBarComponent } from '../../components/side-bar/side-bar.component';
import { RouterOutlet } from '@angular/router';
import { animate, state, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-ticket-main',
  standalone: true,
  imports: [CommonModule, SideBarComponent, RouterOutlet],
  templateUrl: './ticket-main.component.html',
  styleUrl: './ticket-main.component.css',
  animations: [
    trigger('contentAnimation', [
      state('shifted', style({
        marginLeft: '16.5rem'  // Ajusta esto al ancho de tu sidebar
      })),
      state('normal', style({
        marginLeft: '4.5rem'
      })),
      transition('shifted <=> normal', [
        animate('0.3s')
      ])
    ])
  ]
})
export class TicketMainComponent {
  contentState: 'shifted' | 'normal' = 'shifted';
  sidebarState: 'open' | 'closed' = 'open';

  toggleSidebar() {
    this.sidebarState = this.sidebarState === 'open' ? 'closed' : 'open';
    this.contentState = this.contentState === 'shifted' ? 'normal' : 'shifted';
  }
}
