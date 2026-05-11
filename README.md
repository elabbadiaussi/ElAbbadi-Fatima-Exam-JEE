# ElAbbadi-Fatima-Exam-JEE

Examen Architecture Distribuée et Middleware  
**Professeur :** Pr. YOUSSFI  
**Étudiante :** Fatima El Abbadi

---

## Description

Application Web JEE de gestion des contrats d'assurance développée avec **Spring Boot** (backend) et **Angular** (frontend).

---

## Technologies utilisées

### Backend
| Technologie | Version |
|---|---|
| Java | 21 |
| Spring Boot | 4.0.6 |
| Spring Data JPA | - |
| Hibernate | 7.x |
| Spring Security | - |
| H2 Database | - |
| Lombok | 1.18.32 |
| SpringDoc OpenAPI | 2.8.8 |

### Frontend
| Technologie | Version |
|---|---|
| Angular | 17+ |
| Bootstrap | 5.3 |
| TypeScript | - |

---

## Structure du projet

```
ElAbbadi-Fatima-Exam-JEE/
├── fatima-elabbadi-exam-jee-backend/
│   └── src/main/java/ma/enset/fatimaelabbadiexamjee/
│       ├── entities/
│       │   ├── Client.java
│       │   ├── Contrat.java
│       │   ├── ContratAutomobile.java
│       │   ├── ContratHabitation.java
│       │   ├── ContratSante.java
│       │   └── Paiement.java
│       ├── enums/
│       │   ├── StatutContrat.java
│       │   ├── TypeLogement.java
│       │   ├── NiveauCouverture.java
│       │   └── TypePaiement.java
│       ├── repositories/
│       ├── dto/
│       ├── mappers/
│       ├── services/
│       ├── controllers/
│       └── config/
└── fatima-elabbadi-exam-jee-frontend/
    └── src/app/
        ├── components/
        ├── pages/
        ├── services/
        └── models/
```

---

## Règles de gestion

- Un **client** peut souscrire plusieurs contrats d'assurance
- Il existe **3 types** de contrats : Automobile, Habitation, Santé
- Un contrat peut avoir plusieurs **paiements**
- 3 statuts de contrat : `EN_COURS`, `VALIDE`, `RESILIE`
- 3 types de paiement : `MENSUALITE`, `PAIEMENT_ANNUEL`, `PAIEMENT_EXCEPTIONNEL`

---

## Lancer le projet

### Backend

```bash
cd fatima-elabbadi-exam-jee-backend
mvn clean spring-boot:run
```

L'API sera disponible sur : `http://localhost:8085`  
Documentation Swagger : `http://localhost:8085/swagger-ui/index.html`

### Frontend

```bash
cd fatima-elabbadi-exam-jee-frontend
npm install
ng serve
```

L'application sera disponible sur : `http://localhost:4200`

---

## Endpoints REST

| Méthode | Endpoint | Description |
|---|---|---|
| GET | `/api/clients` | Liste des clients |
| POST | `/api/clients` | Créer un client |
| PUT | `/api/clients/{id}` | Modifier un client |
| DELETE | `/api/clients/{id}` | Supprimer un client |
| GET | `/api/contrats/automobile` | Liste des contrats auto |
| GET | `/api/contrats/habitation` | Liste des contrats habitation |
| GET | `/api/contrats/sante` | Liste des contrats santé |
| GET | `/api/paiements/contrat/{id}` | Paiements d'un contrat |

---

## Architecture

```
Angular  ──HTTP/JSON──►  REST Controllers
                              │
                         Service Layer  ◄──► DTOs / Mappers
                              │
                         Repository (DAO)
                              │
                         Base de données H2
```

---

## Diagramme de classes

Les entités principales :

- `Client` → `Contrat` (1 à plusieurs)
- `Contrat` → `Paiement` (1 à plusieurs)
- `Contrat` ← `ContratAutomobile` / `ContratHabitation` / `ContratSante` (héritage SINGLE_TABLE)
