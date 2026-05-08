DROP DATABASE IF EXISTS fourage;

CREATE DATABASE fourage;

use fourage

CREATE TABLE clients (
    id          INT PRIMARY KEY AUTO_INCREMENT,
    nom         VARCHAR(255) NOT NULL,
    prenom      VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL,
    adresse    VARCHAR(255) NOT NULL
);

CREATE TABLE regions (
    id          INT PRIMARY KEY AUTO_INCREMENT,
    libelle     VARCHAR(255) NOT NULL
);

CREATE TABLE districts (
    id          INT PRIMARY KEY AUTO_INCREMENT,
    libelle     VARCHAR(255) NOT NULL,
    idRegion    INT NOT NULL,
    FOREIGN KEY (idRegion) REFERENCES regions(id)
);

CREATE TABLE communes (
    id          INT PRIMARY KEY AUTO_INCREMENT,
    libelle     VARCHAR(255) NOT NULL,
    idDistrict  INT NOT NULL,
    FOREIGN KEY (idDistrict) REFERENCES districts(id)
);

CREATE TABLE demandes(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    idClient    INT NOT NULL,
    lieu        VARCHAR(255) NOT NULL,
    idCommune   INT NOT NULL,
    reference   VARCHAR(255) NOT NULL,
    daty        DATETIME NOT NULL,
    FOREIGN KEY (idClient) REFERENCES clients(id)
);

CREATE TABLE statuts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    libelle VARCHAR(255) NOT NULL
);

CREATE TABLE statutDemandes (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    idDemande   INT NOT NULL,
    idStatut    INT NOT NULL,
    daty        DATETIME NOT NULL,
    FOREIGN KEY (idDemande) REFERENCES demandes(id),
    FOREIGN KEY (idStatut) REFERENCES statuts(id)
);
