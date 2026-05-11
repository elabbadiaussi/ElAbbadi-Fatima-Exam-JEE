import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  styles: [`
    .navbar {
      background: linear-gradient(135deg, #1e3a5f 0%, #2563eb 100%) !important;
      box-shadow: 0 2px 12px rgba(0,0,0,0.15);
      padding: 0.75rem 0;
    }
    .navbar-brand {
      font-size: 1.3rem;
      font-weight: 700;
      letter-spacing: 0.5px;
      color: #ffffff !important;
    }
    .brand-dot {
      display: inline-block;
      width: 8px;
      height: 8px;
      background: #f59e0b;
      border-radius: 50%;
      margin-right: 6px;
      margin-bottom: 2px;
    }
    .nav-link {
      color: rgba(255,255,255,0.8) !important;
      font-weight: 500;
      font-size: 0.92rem;
      padding: 0.45rem 1rem !important;
      border-radius: 8px;
      margin: 0 2px;
      transition: all 0.2s ease;
      letter-spacing: 0.3px;
    }
    .nav-link:hover {
      color: #ffffff !important;
      background: rgba(255,255,255,0.12);
    }
    .nav-link.active {
      color: #ffffff !important;
      background: rgba(255,255,255,0.18);
      font-weight: 600;
    }
    .divider {
      width: 1px;
      height: 20px;
      background: rgba(255,255,255,0.2);
      margin: 0 6px;
      align-self: center;
    }
    .avatar {
      width: 30px;
      height: 30px;
      background: #f59e0b;
      border-radius: 50%;
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 0.72rem;
      font-weight: 700;
      color: white;
    }
    .user-pill {
      background: rgba(255,255,255,0.12);
      border-radius: 20px;
      padding: 4px 12px 4px 6px;
      display: flex;
      align-items: center;
      gap: 8px;
    }
    .user-name {
      color: white;
      font-size: 0.85rem;
      font-weight: 500;
    }
  `],
  template: `
    <nav class="navbar navbar-expand-lg">
      <div class="container">

        <a class="navbar-brand d-flex align-items-center" routerLink="/">
          <span class="brand-dot"></span>
          AssuranceApp
        </a>

        <button class="navbar-toggler border-0" type="button"
                data-bs-toggle="collapse" data-bs-target="#navMenu"
                style="color:white">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navMenu">
          <ul class="navbar-nav ms-auto align-items-center">

            <li class="nav-item">
              <a class="nav-link" routerLink="/"
                 routerLinkActive="active"
                 [routerLinkActiveOptions]="{exact:true}">
                Accueil
              </a>
            </li>

            <li class="nav-item">
              <a class="nav-link" routerLink="/clients"
                 routerLinkActive="active">
                Clients
              </a>
            </li>

            <li class="nav-item">
              <a class="nav-link" routerLink="/contrats"
                 routerLinkActive="active">
                Contrats
              </a>
            </li>

            <li class="nav-item">
              <a class="nav-link" routerLink="/paiements"
                 routerLinkActive="active">
                Paiements
              </a>
            </li>

            <div class="divider d-none d-lg-block"></div>

            <li class="nav-item ms-1">
              <div class="user-pill">
                <div class="avatar">FA</div>
                <span class="user-name">Fatima</span>
              </div>
            </li>

          </ul>
        </div>
      </div>
    </nav>
  `
})
export class NavbarComponent {}