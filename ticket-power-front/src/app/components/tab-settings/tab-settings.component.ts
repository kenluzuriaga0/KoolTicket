import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-tab-settings',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './tab-settings.component.html',
  styleUrl: './tab-settings.component.css'
})
export class TabSettingsComponent {

}
