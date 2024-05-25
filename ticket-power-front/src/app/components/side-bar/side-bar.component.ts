import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { animate, state, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-side-bar',
  standalone: true,
  imports: [CommonModule,],
  templateUrl: './side-bar.component.html',
  styleUrl: './side-bar.component.css',
  animations: [
    trigger('sidebarAnimation', [
      state('open', style({
        transform: 'translateX(0)'
      })),
      state('closed', style({
        transform: 'translateX(-100%)'
      })),
      transition('open <=> closed', [
        animate('0.3s')
      ])
    ])
  ]
})
export class SideBarComponent {
  sidebarState: 'open' | 'closed' = 'open';

  toggleSidebar() {
    this.sidebarState = this.sidebarState === 'open' ? 'closed' : 'open';
  }
}
