import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListUsersComponent } from './list-users/list-users.component';
import { RouterOutlet } from '@angular/router';
import { TabSettingsComponent } from '../../components/tab-settings/tab-settings.component';

@Component({
  selector: 'app-settings',
  standalone: true,
  imports: [CommonModule, ListUsersComponent, RouterOutlet, TabSettingsComponent],
  templateUrl: './settings.component.html',
  styleUrl: './settings.component.css'
})
export class SettingsComponent {

}
