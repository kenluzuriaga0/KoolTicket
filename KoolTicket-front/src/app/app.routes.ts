import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SelectBranchComponent } from './pages/select-branch/select-branch.component';
import { TicketCallComponent } from './pages/ticket-main/ticket-call/ticket-call.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { TicketDispenserComponent } from './pages/ticket-main/ticket-dispenser/ticket-dispenser.component';
import { TicketWaitListComponent } from './pages/ticket-main/ticket-wait-list/ticket-wait-list.component';
import { SettingsComponent } from './pages/settings/settings.component';
import { TicketMainComponent } from './pages/ticket-main/ticket-main.component';
import { FormUserComponent } from './pages/settings/form-user/form-user.component';
import { ListUsersComponent } from './pages/settings/list-users/list-users.component';
import { ManageQueueComponent } from './pages/settings/manage-queue/manage-queue.component';
import { ListButtonsComponent } from './pages/settings/list-buttons/list-buttons.component';
import { FormButtonComponent } from './pages/settings/form-button/form-button.component';
import { FormBranchComponent } from './pages/settings/form-branch/form-branch.component';
import { ListBranchesComponent } from './pages/settings/list-branches/list-branches.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'branch', component: SelectBranchComponent },
    { path: 'config', component: SettingsComponent, },
    {
        path: 'ticket', component: TicketMainComponent,
        children: [
            { path: 'call', component: TicketCallComponent },
            { path: 'dispenser', component: TicketDispenserComponent },
            { path: 'waitlist', component: TicketWaitListComponent },
            { path: 'queue', component: ManageQueueComponent },
            {
                path: 'config', component: SettingsComponent,
                children: [
                    { path: 'user', component: ListUsersComponent },
                    { path: 'user/:id', component: FormUserComponent },
                    { path: 'user/create', component: FormUserComponent },
                    { path: 'button', component: ListButtonsComponent },
                    { path: 'button/create', component: FormButtonComponent },
                    { path: 'button/:id', component: FormButtonComponent },
                    { path: 'branch/create', component: FormBranchComponent },
                    { path: 'branch', component: ListBranchesComponent },
                    { path: 'branch/:id', component: FormBranchComponent },
                ]
            },
        ]
    },
    { path: '**', component: NotFoundComponent },
];
