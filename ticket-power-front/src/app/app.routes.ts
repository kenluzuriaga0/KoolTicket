import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SelectBranchComponent } from './pages/select-branch/select-branch.component';
import { TicketCallComponent } from './pages/ticket-call/ticket-call.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'branch', component: SelectBranchComponent },
    { path: 'call', component: TicketCallComponent }, // TODO: Colocar un child ":branchId"
    { path: '**', component: NotFoundComponent },
];
