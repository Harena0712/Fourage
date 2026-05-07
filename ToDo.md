# Fourage - ToDo List

# Commande de lancement du projet
```
mvn clean package
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


### Les services
- [x] Créer la classe `ClientService` avec le méthode suivant :
  - `void saveClient(Client client)`

- [x] Créer la classe `RegionService` avec le méthode suivant :
  - `void saveRegion(Region region)`

- [x] Créer la classe `DistrictService` avec le méthode suivant :
  - `void saveDistrict(District district)`

- [x] Créer la classe `CommuneService` avec le méthode suivant :
  - `void saveCommune(Commune commune)`

- [x] Créer la classe `DemandeService` avec le méthode suivant :
  - `void saveDemande(Demande demande)`
  - `List<Demande> getAllDemandes()`
  - `List<Demande> getDemandeById(int id)`
  - `void deleteDemande(int id)`

- [x] Créer la classe `StatutService` avec le méthode suivant :
  - `void saveStatut(Statut statut)`

- [x] Créer la classe `StatutDemandeService` avec le méthode suivant :
  - `void saveStatutDemande(StatutDemande statutDemande)`

### Les controllers
- [ ] Créer la classe `ClientController` avec le méthode suivant :
  - url `/client/formulaire` pour la fonction `formulaire()`
  - url `/client/ajouter` pour la fonction `ajouter()`
  
- [ ] Créer la classe `RegionController` avec le méthode suivant :
  - url `/region/formulaire` pour la fonction `formulaire()`
  - url `/region/ajouter` pour la fonction `ajouter()`

- [ ] Créer la classe `DistrictController` avec le méthode suivant :
  - url `/district/formulaire` pour la fonction `formulaire()`
  - url `/district/ajouter` pour la fonction `ajouter()`

- [ ] Créer la classe `CommuneController` avec le méthode suivant :
  - url `/commune/formulaire` pour la fonction `formulaire()`
  - url `/commune/ajouter` pour la fonction `ajouter()`

- [ ] Créer la classe `DemandeController` avec le méthode suivant :
  - url `/demande/formulaire` pour la fonction `formulaire()`
  - url `/demande/ajouter` pour la fonction `ajouter()`
  - url `/demande/lister` pour la fonction `lister()`
  - url `/demande/supprimer/<id>` pour la fonction `supprimer()`

- [ ] Créer la classe `StatutController` avec le méthode suivant :
  - url `/statut/formulaire` pour la fonction `formulaire()`
  - url `/statut/ajouter` pour la fonction `ajouter()`

- [ ] Créer la classe `StatutDemandeController` avec le méthode suivant :
  - url `/statut-demande/formulaire` pour la fonction `formulaire()`
  - url `/statut-demande/ajouter` pour la fonction `ajouter()`

## Les vues
- [ ] Créer la vue `demande/formulaire.jsp` pour le formulaire de création d'une demande
- [ ] Créer la vue `demande/lister.jsp` pour la liste des demandes
- [ ] Créer la vue `client/formulaire.jsp` pour le formulaire de création d'un client
- [ ] Créer la vue `region/formulaire.jsp` pour le formulaire de création d'une région
- [ ] Créer la vue `district/formulaire.jsp` pour le formulaire de création d'un district
- [ ] Créer la vue `commune/formulaire.jsp` pour le formulaire de création d'une commune
- [ ] Créer la vue `statut/formulaire.jsp` pour le formulaire de création d'un statut
- [ ] Créer la vue `statutDemande/formulaire.jsp` pour le formulaire de création d'un statut de demande



