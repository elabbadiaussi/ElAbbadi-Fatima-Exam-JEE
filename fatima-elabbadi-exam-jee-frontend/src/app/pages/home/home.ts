import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink],
  styles: [`
    .hero {
      background: linear-gradient(135deg, #1e3a5f 0%, #2563eb 100%);
      border-radius: 16px;
      padding: 60px 40px;
      color: white;
      margin-bottom: 40px;
    }
    .hero h1 {
      font-size: 2rem;
      font-weight: 700;
      letter-spacing: -0.5px;
    }
    .hero p {
      font-size: 1rem;
      opacity: 0.8;
      margin-bottom: 0;
    }
    .stat-badge {
      background: rgba(255,255,255,0.15);
      border-radius: 10px;
      padding: 10px 20px;
      display: inline-block;
      font-size: 0.85rem;
      font-weight: 500;
    }
    .feature-card {
      border: none;
      border-radius: 14px;
      box-shadow: 0 2px 16px rgba(0,0,0,0.07);
      transition: transform 0.2s ease, box-shadow 0.2s ease;
      height: 100%;
    }
    .feature-card:hover {
      transform: translateY(-4px);
      box-shadow: 0 8px 24px rgba(0,0,0,0.12);
    }
    .card-top-bar {
      height: 4px;
      border-radius: 14px 14px 0 0;
    }
    .card-title {
      font-size: 1.1rem;
      font-weight: 700;
      color: #1e293b;
    }
    .card-text {
      font-size: 0.88rem;
      color: #64748b;
      line-height: 1.6;
    }
    .btn-action {
      font-size: 0.85rem;
      font-weight: 600;
      padding: 8px 20px;
      border-radius: 8px;
      border: none;
    }
    .info-bar {
      background: #f8fafc;
      border-radius: 12px;
      padding: 16px 24px;
      border-left: 4px solid #2563eb;
    }
  `],
  template: `
  

    <div class="row g-4 mb-4">

      <div class="col-md-4">
        <div class="feature-card card">
          <div class="card-top-bar bg-primary"></div>
          <div class="card-body p-4">
            <h5 class="card-title mb-2">Clients</h5>
            <p class="card-text mb-4">
              Consulter, ajouter, modifier et supprimer les clients
              de la plateforme d'assurance.
            </p>
            <a routerLink="/clients" class="btn btn-primary btn-action w-100">
              Gérer les clients
            </a>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="feature-card card">
          <div class="card-top-bar bg-success"></div>
          <div class="card-body p-4">
            <h5 class="card-title mb-2">Contrats</h5>
            <p class="card-text mb-4">
              Gérer les contrats automobile, habitation et santé
              avec leurs statuts et cotisations.
            </p>
            <a routerLink="/contrats" class="btn btn-success btn-action w-100">
              Gérer les contrats
            </a>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="feature-card card">
          <div class="card-top-bar bg-warning"></div>
          <div class="card-body p-4">
            <h5 class="card-title mb-2">Paiements</h5>
            <p class="card-text mb-4">
              Suivre les mensualités, paiements annuels et
              paiements exceptionnels par contrat.
            </p>
            <a routerLink="/paiements" class="btn btn-warning btn-action w-100">
              Voir les paiements
            </a>
          </div>
        </div>
      </div>

    </div>

   
  `
})
export class HomeComponent {}