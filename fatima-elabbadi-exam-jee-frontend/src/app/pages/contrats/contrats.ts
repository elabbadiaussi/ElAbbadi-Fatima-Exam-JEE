import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-contrats',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="d-flex justify-content-between align-items-center mb-4">
      <h2 class="fw-bold">📋 Gestion des Contrats</h2>
    </div>

    <div class="row g-3 mb-4">
      <div class="col-md-4">
        <div class="card border-warning text-center p-3 h-100">
          <div class="fs-2">🚗</div>
          <h6 class="mt-2">Contrats Automobile</h6>
          <span class="badge bg-warning text-dark">À implémenter</span>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card border-info text-center p-3 h-100">
          <div class="fs-2">🏠</div>
          <h6 class="mt-2">Contrats Habitation</h6>
          <span class="badge bg-info text-white">À implémenter</span>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card border-success text-center p-3 h-100">
          <div class="fs-2">🏥</div>
          <h6 class="mt-2">Contrats Santé</h6>
          <span class="badge bg-success text-white">À implémenter</span>
        </div>
      </div>
    </div>


  `
})
export class ContratsComponent implements OnInit {
  ngOnInit(): void {}
}