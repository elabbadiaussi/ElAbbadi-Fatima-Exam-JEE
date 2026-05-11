import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { ClientsComponent } from './pages/clients/clients';
import { ContratsComponent } from './pages/contrats/contrats';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'clients', component: ClientsComponent },
  { path: 'contrats', component: ContratsComponent },
  { path: '**', redirectTo: '' }
];