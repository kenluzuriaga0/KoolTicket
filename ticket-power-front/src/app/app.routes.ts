import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SelectBranchComponent } from './pages/select-branch/select-branch.component';
import { TicketCallComponent } from './pages/ticket-call/ticket-call.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { TicketDispenserComponent } from './pages/ticket-dispenser/ticket-dispenser.component';
import { TicketWaitListComponent } from './pages/ticket-wait-list/ticket-wait-list.component';
import { SettingsComponent } from './pages/settings-admin/settings.component';
import { TicketMainComponent } from './pages/ticket-main/ticket-main.component';
import { CreateNewUserComponent } from './pages/settings-admin/create-new-user/create-new-user.component';
import { ListUsersComponent } from './pages/settings-admin/list-users/list-users.component';
import { ManageQueueComponent } from './pages/settings-admin/manage-queue/manage-queue.component';

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
        { path: 'users', component: ListUsersComponent },
        { path: 'create', component: CreateNewUserComponent },
        { path: 'queue', component: ManageQueueComponent }
       

    ]
    }, // TODO: Colocar un child ":branchId"
    { path: '**', component: NotFoundComponent },

   
];
