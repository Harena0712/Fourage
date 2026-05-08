INSERT INTO regions (libelle) VALUES
('Analamanga'),
('Vakinankaratra'),
('Boeny'),
('Atsinanana'),
('Anosy'),
('Alaotra-Mangoro'),
('Sava');

INSERT INTO districts (libelle, idRegion) VALUES
('Antananarivo-Renivohitra', 1),
('Antananarivo-Avaradrano', 1),
('Antsirabe I', 2),
('Mahajanga I', 3),
('Toamasina I', 4),
('Taolagnaro', 5),
('Ambatondrazaka', 6);

INSERT INTO communes (libelle, idDistrict) VALUES
('Analakely', 1),
('Ambohimanarina', 2),
('Antsirabe Ville', 3),
('Mahajanga Centre', 4),
('Toamasina Centre', 5),
('Taolagnaro Ville', 6),
('Ambatondrazaka Ville', 7);

INSERT INTO clients (nom, prenom, email, adresse) VALUES
('Rakoto', 'Jean', 'jean.rakoto@gmail.com', 'Analakely, Antananarivo'),
('Rabe', 'Marie', 'marie.rabe@yahoo.com', 'Ambohimanarina, Antananarivo'),
('Rasoa', 'Andry', 'andry.rasoa@gmail.com', 'Antsirabe Centre, Vakinankaratra'),
('Rakotondrazaka', 'Hery', 'hery.rakoto@gmail.com', 'Mahajanga Centre, Boeny'),
('Ravelo', 'Clara', 'clara.ravelo@hotmail.com', 'Toamasina Ville, Atsinanana');

INSERT INTO statuts (libelle) VALUES
('Demande reçue'),
('En attente'),
('En cours'),
('Terminé'),
('Annulé');