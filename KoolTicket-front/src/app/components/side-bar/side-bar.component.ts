import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-side-bar',
  standalone: true,
  imports: [CommonModule, RouterLink],
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
    ]),
    trigger('dropdownAnimation', [
      transition(':enter', [
        style({ height: '0px', opacity: 0 }),
        animate('0.2s ease-out', style({ height: '*', opacity: 1 }))
      ]),
      transition(':leave', [
        animate('0.2s ease-in', style({ height: '0px', opacity: 0 }))
      ])
    ])
  ],
  
})
export class SideBarComponent {
  @Input() sidebarState: 'open' | 'closed';

  dropdownOpen: boolean = false;

  toggleDropdown() {
    this.dropdownOpen = !this.dropdownOpen;
  }

}
