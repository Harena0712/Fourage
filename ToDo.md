# Fourage - ToDo List

# Commande de lancement du projet
```
mvn package
cp target/*.war /home/harena/Documents/ITU/S4/tomcat10/webapps
./startup.sh
http://localhost:8080/nomDuProjet
```

# Structure du projet
```
mon-projet/
│
├── pom.xml
│
└── src/
    └── main/
        ├── java/
        │   └── com/spring/
        │       ├── config/
        │       │   ├── WebConfig.java
        │       │   └── DatabaseConfig.java
        │       │
        │       ├── model/
        │       │   └── User.java
        │       │
        │       ├── repository/
        │       │   └── UserRepository.java
        │       │
        │       ├── service/
        │       │   └── UserService.java
        │       │
        │       └── controller/
        │           └── UserController.java
        │
        └── webapp/
            └── WEB-INF/
                ├── web.xml
                └── views/
                    └── user.jsp
```

## Base de données

- [x] Créer la table `clients` avec les champs suivants :
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `nom` (VARCHAR(255))
  - `prenom` (VARCHAR(255))
  - `email` (VARCHAR(255))
  - `adresse` (VARCHAR(255))

- [x] Créer la table `regions` avec les champs suivants :
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `labelle` (VARCHAR(255))

- [x] Créer la table `districts` avec les champs suivants :
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `labelle` (VARCHAR(255))
  - `idRegion` (INT)

- [x] Créer la table `communes` avec les champs suivants :
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `labelle` (VARCHAR(255))
  - `idDistrict` (INT)

- [x] Créer la table `demandes` avec les champs suivants :
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `idClient` (INT)
  - `idCommune` (INT)
  - `reference` (VARCHAR(255))
  - `daty` (DATETIME)
  - `lieu` (VARCHAR(255))

- [x] Créer la table `statuts` avec les champs suivants :
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `labelle` (VARCHAR(255))

- [x] Créer la table `statutDemandes` avec les champs suivants :
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `idDemande` (INT)
  - `idStatut` (INT)
  - `daty` (DATETIME)

- [x] Créer la table `types` avec les champs suivants :
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `libelle` (VARCHAR(255))

- [x] Créer la table `devis` avec les champs suivants :
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `idDemande` (INT)
  - `idType` (INT)
  - `description` (VARCHAR(255))
  - `daty` (DATETIME)

- [x] Créer la table `devisDetails` avec les champs suivants :
  - `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
  - `idDevis` (INT)
  - `libelle` (VARCHAR(255))
  - `qnt` (INT)
  - `PU` (DECIMAL)
## Modeles, Repository, Service, Controller
### Les modeles
- [x] Créer la classe `Client` avec les champs suivants :
  - `id` (int)
  - `nom` (String)
  - `prenom` (String)
  - `email` (String)
  - `adresse` (String)
  - `demandes` (List<Demande>)

- [x] Créer la classe `Region` avec les champs suivants :
  - `id` (int)
  - `labelle` (String)
  - `districts` (List<District>)

- [x] Créer la classe `District` avec les champs suivants :
  - `id` (int)
  - `labelle` (String)
  - `idRegion` (int)
  - `communes` (List<Commune>)

- [x] Créer la classe `Commune` avec les champs suivants :
  - `id` (int)
  - `labelle` (String)
  - `idDistrict` (int)
  - `demandes` (List<Demande>)

- [x] Créer la classe `Demande` avec les champs suivants :
  - `id` (int)
  - `idClient` (int)
  - `idCommune` (int)
  - `reference` (String)
  - `daty` (LocalDateTime)
  - `lieu` (String)
  - `statutDemandes` (List<StatutDemande>)

- [x] Créer la classe `Statut` avec les champs suivants :
  - `id` (int)
  - `labelle` (String)
  - `statutDemandes` (List<StatutDemande>)

- [x] Créer la classe `StatutDemande` avec les champs suivants :
  - `id` (int)
  - `idDemande` (int)
  - `idStatut` (int)
  - `daty` (LocalDateTime)

- [x] Créer la classe `Devis` avec les champs suivants :
  - `id` (int)
  - `idDemande` (int)
  - `qnt` (int)
  - `unite` (String)
  - `PU` (double)
  - `description` (String)
  - `daty` (LocalDateTime)
  - `total` (double)

### Les repositories
- [x] Créer l'interface `ClientRepository` avec le méthode suivant :
  - `void save(Client client)`

- [x] Créer l'interface `RegionRepository` avec le méthode suivant :
  - `void save(Region region)`

- [x] Créer l'interface `DistrictRepository` avec le méthode suivant :
  - `void save(District district)`

- [x] Créer l'interface `CommuneRepository` avec le méthode suivant :
  - `void save(Commune commune)`

- [x] Créer l'interface `DemandeRepository` avec le méthode suivant :
  - `void save(Demande demande)`
  - `List<Demande> findAll()`
  - `List<Demande> findById(int id)`
  - `void delete(int id)`

- [x] Créer l'interface `StatutRepository` avec le méthode suivant :
  - `void save(Statut statut)`

- [x] Créer l'interface `StatutDemandeRepository` avec le méthode suivant :
  - `void save(StatutDemande statutDemande)`

- [x] Créer l'interface `DevisRepository` avec le méthode suivant :
  - `void save(Devis devis)`
  - `List<Devis> findAll()`
  - `List<Devis> findById(int id)`
  - `void delete(int id)`


### Les services
- [x] Créer la classe `ClientService` avec le méthode suivant :
  - `void save(Client client)`

- [x] Créer la classe `RegionService` avec le méthode suivant :
  - `void save(Region region)`

- [x] Créer la classe `DistrictService` avec le méthode suivant :
  - `void save(District district)`

- [x] Créer la classe `CommuneService` avec le méthode suivant :
  - `void save(Commune commune)`

- [x] Créer la classe `DemandeService` avec le méthode suivant :
  - `void save(Demande demande)`
  - `List<Demande> getAll()`
  - `List<Demande> getById(int id)`
  - `void delete(int id)`

- [x] Créer la classe `StatutService` avec le méthode suivant :
  - `void save(Statut statut)`

- [x] Créer la classe `StatutDemandeService` avec le méthode suivant :
  - `void save(StatutDemande statutDemande)`

- [x] Créer la classe `DevisService` avec le méthode suivant :
  - `void save(Devis devis)`
  - `List<Devis> getAll()`
  - `List<Devis> getById(int id)`
  - `void delete(int id)`

### Les controllers
- [ ] Créer la classe `ClientController` avec le méthode suivant :
  - [ ] url `/client/formulaire` pour la fonction `formulaire()`
  - [ ] url `/client/ajouter` pour la fonction `ajouter()`
  
- [ ] Créer la classe `RegionController` avec le méthode suivant :
  - [ ] url `/region/formulaire` pour la fonction `formulaire()`
  - [ ] url `/region/ajouter` pour la fonction `ajouter()`

- [ ] Créer la classe `DistrictController` avec le méthode suivant :
  - [ ] url `/district/formulaire` pour la fonction `formulaire()`
  - [ ] url `/district/ajouter` pour la fonction `ajouter()`

- [ ] Créer la classe `CommuneController` avec le méthode suivant :
  - [ ] url `/commune/formulaire` pour la fonction `formulaire()`
  - [ ] url `/commune/ajouter` pour la fonction `ajouter()`

- [ ] Créer la classe `DemandeController` avec le méthode suivant :
  - [x] url `/demande/formulaire` pour la fonction `formulaire()`
  - [x] url `/demande/ajouter` pour la fonction `ajouter()`
  - [ ] url `/demande/lister` pour la fonction `lister()`
  - [ ] url `/demande/supprimer/<id>` pour la fonction `supprimer()`

- [ ] Créer la classe `StatutController` avec le méthode suivant :
  - [ ] url `/statut/formulaire` pour la fonction `formulaire()`
  - [ ] url `/statut/ajouter` pour la fonction `ajouter()`

- [ ] Créer la classe `StatutDemandeController` avec le méthode suivant :
  - [ ] url `/statut-demande/formulaire` pour la fonction `formulai()`
  - [ ] url `/statut-demande/ajouter` pour la fonction `ajouter()`

- [ ] Créer la classe `DevisController` avec le méthode suivant :
  - [ ] url `/devis/formulaire` pour la fonction `formulaire()`
  - [ ] url `/devis/ajouter` pour la fonction `ajouter()`
  - [ ] url `/devis/lister` pour la fonction `lister()`
  - [ ] url `/devis/supprimer/<id>` pour la fonction `supprimer()`

## Les vues
- [x] Créer la vue `demande/formulaire.jsp` pour le formulaire de création d'une demande
- [ ] Créer la vue `demande/lister.jsp` pour la liste des demandes
- [ ] Créer la vue `client/formulaire.jsp` pour le formulaire de création d'un client
- [ ] Créer la vue `region/formulaire.jsp` pour le formulaire de création d'une région
- [ ] Créer la vue `district/formulaire.jsp` pour le formulaire de création d'un district
- [ ] Créer la vue `commune/formulaire.jsp` pour le formulaire de création d'une commune
- [ ] Créer la vue `statut/formulaire.jsp` pour le formulaire de création d'un statut
- [ ] Créer la vue `statutDemande/formulaire.jsp` pour le formulaire de création d'un statut de demande
- [x] Créer la vue `devis/formulaire.jsp` pour le formulaire de création d'une devis
- [ ] Créer la vue `devis/lister.jsp` pour la liste des devis



Creation devis

details (date,...)
    => ligne par ligne [lavaka, tuillon, etc]   avec statut  
    => qnt, unité, PU, description, Total A saisir

interface d'entrer
lister les devis entrés

Table

types:
    etude, 
    forage

Devis :
    id, 
    idType, 
    libelle, 
    date, 
    description
  
devisDetails:
    idDevis,
    libelle,
    qnt,
    montant (PU)



Formulaire devis
  - Ref-DEmande (Afficher automatiquement apres avoir choisi le Ref-Demande)
      Client
      date,
      lieu

  - Type
        action 
          bouton ajouter une ligne pour avoir plusieurs devisDetails
          bouton supprimer une ligne
  - DevisDetail (fieldSet)
    - libelle
    - qnt
    - montant (PU)

  - Date



Insertion
devis, demandeStatut, devisDetails


