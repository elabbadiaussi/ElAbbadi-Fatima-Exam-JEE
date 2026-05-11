import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Client } from '../../models/client';
import { ClientService } from '../../services/client';

@Component({
  selector: 'app-clients',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="d-flex justify-content-between align-items-center mb-4">
      <h2 class="fw-bold"> Gestion des Clients</h2>
      <button class="btn btn-primary" (click)="openForm()">+ Nouveau client</button>
    </div>

    <div class="input-group mb-4 w-50">
      <input type="text" class="form-control" placeholder="Rechercher par nom..."
             [(ngModel)]="searchTerm" (input)="onSearch()"/>
      <button class="btn btn-outline-secondary" (click)="loadClients()">✕</button>
    </div>

    <div *ngIf="showForm" class="card mb-4 shadow-sm border-primary">
      <div class="card-header bg-primary text-white fw-bold">
        {{ selectedClient?.id ? 'Modifier le client' : 'Nouveau client' }}
      </div>
      <div class="card-body">
        <div class="row g-3">
          <div class="col-md-6">
            <label class="form-label">Nom</label>
            <input type="text" class="form-control" [(ngModel)]="form.nom" placeholder="Nom complet"/>
          </div>
          <div class="col-md-6">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" [(ngModel)]="form.email" placeholder="email@exemple.com"/>
          </div>
        </div>
        <div class="mt-3 d-flex gap-2">
          <button class="btn btn-success" (click)="saveClient()"> Enregistrer</button>
          <button class="btn btn-secondary" (click)="cancelForm()">Annuler</button>
        </div>
      </div>
    </div>

    <div *ngIf="loading" class="text-center py-4">
      <div class="spinner-border text-primary"></div>
    </div>

    <div *ngIf="!loading">
      <div class="table-responsive shadow-sm rounded">
        <table class="table table-hover table-bordered mb-0">
          <thead class="table-primary">
            <tr>
              <th>#</th>
              <th>Nom</th>
              <th>Email</th>
              <th>Contrats</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <tr *ngFor="let client of clients">
              <td>{{ client.id }}</td>
              <td>{{ client.nom }}</td>
              <td>{{ client.email }}</td>
              <td><span class="badge bg-info">{{ client.nombreContrats ?? 0 }}</span></td>
              <td>
                <button class="btn btn-sm btn-warning me-1" (click)="editClient(client)">✏️</button>
                <button class="btn btn-sm btn-danger" (click)="deleteClient(client.id!)">🗑️</button>
              </td>
            </tr>
            <tr *ngIf="clients.length === 0">
              <td colspan="5" class="text-center text-muted py-3">Aucun client trouvé</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  `
})
export class ClientsComponent implements OnInit {

  clients: Client[] = [];
  loading = false;
  showForm = false;
  searchTerm = '';
  selectedClient: Client | null = null;
  form: Client = { nom: '', email: '' };

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {
    this.loadClients();
  }

  loadClients(): void {
    this.loading = true;
    this.searchTerm = '';
    this.clientService.getAll().subscribe({
      next: data => { this.clients = data; this.loading = false; },
      error: () => this.loading = false
    });
  }

  onSearch(): void {
    if (this.searchTerm.trim()) {
      this.clientService.search(this.searchTerm).subscribe(data => this.clients = data);
    } else {
      this.loadClients();
    }
  }

  openForm(): void {
    this.showForm = true;
    this.selectedClient = null;
    this.form = { nom: '', email: '' };
  }

  editClient(client: Client): void {
    this.selectedClient = client;
    this.form = { nom: client.nom, email: client.email };
    this.showForm = true;
  }

  saveClient(): void {
    if (this.selectedClient?.id) {
      this.clientService.update(this.selectedClient.id, this.form).subscribe(() => {
        this.loadClients(); this.cancelForm();
      });
    } else {
      this.clientService.create(this.form).subscribe(() => {
        this.loadClients(); this.cancelForm();
      });
    }
  }

  deleteClient(id: number): void {
    if (confirm('Supprimer ce client ?')) {
      this.clientService.delete(id).subscribe(() => this.loadClients());
    }
  }

  cancelForm(): void {
    this.showForm = false;
    this.selectedClient = null;
  }
}