import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SelectBranchComponent } from './pages/select-branch/select-branch.component';
import { TicketCallComponent } from './pages/ticket-main/ticket-call/ticket-call.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { TicketDispenserComponent } from './pages/ticket-main/ticket-dispenser/ticket-dispenser.component';
import { TicketWaitListComponent } from './pages/ticket-main/ticket-wait-list/ticket-wait-list.component';
import { SettingsComponent } from './pages/settings/settings.component';
import { TicketMainComponent } from './pages/ticket-main/ticket-main.component';
import { CreateNewUserComponent } from './pages/settings/create-new-user/create-new-user.component';
import { ListUsersComponent } from './pages/settings/list-users/list-users.component';
import { ManageQueueComponent } from './pages/settings/manage-queue/manage-queue.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'branch', component: SelectBranchComponent },
    { path: 'settings', component: SettingsComponent},
    { path: 'ticket', component: TicketMainComponent ,
    children:[
        { path: 'call', component: TicketCallComponent },
        { path: 'dispenser', component: TicketDispenserComponent },
        { path: 'waitlist', component: TicketWaitListComponent},
        { path: 'settings', component: SettingsComponent},
        { path: 'user', component: ListUsersComponent },
        { path: 'user/:id', component: CreateNewUserComponent },
        { path: 'create', component: CreateNewUserComponent },
        { path: 'queue', component: ManageQueueComponent },
        { path: 'button', component: ListUsersComponent },
        { path: 'button/:id', component: CreateNewUserComponent },
    ]
    }, // TODO: Colocar un child ":branchId"
    { path: '**', component: NotFoundComponent },

   
];
