-- Acteurs
INSERT INTO acteur (act_nom, act_prenom, act_nationalite, act_date_naissance)
VALUES
('G', 'R', 'EN', '1987-02-04'),
('GARY', 'Halfonse', 'FR', '1947-11-04');


-- Réalisateurs
INSERT INTO realisateur (real_nom, real_prenom, real_nationalite, real_date_naissance)
VALUES
('R', '1', 'EN', '1977-02-04'),
('R', '2', 'FR', '1997-11-04');


-- Genres
INSERT INTO genre (gen_nom)
VALUES
('Humour'),
('Horreur'),
('Fantaisie'),
('Action');


-- Films
INSERT INTO film (film_nom, film_date_sortie)
VALUES
('Scary Movie', '2001-01-31');

INSERT INTO film_genre
VALUES
(1, 1),
(1, 2);


-- Séries, saisons & épisodes
INSERT INTO serie (ser_nom, ser_date_sortie, ser_saisons)
VALUES
('The Walking Dead', '2001-02-10', 11);

INSERT INTO saison (sai_numero, sai_date_sortie, sai_episodes, sai_serie_id)
VALUES
(1, '2001-02-10', 8, 1),
(2, '2002-02-10', 16, 1);

INSERT INTO episode (epi_numero, epi_date_sortie, epi_saison_id)
VALUES
(1, '2001-02-10', 1),
(2, '2001-02-10', 1),
(3, '2001-02-10', 1),
(4, '2001-02-10', 1),
(1, '2002-02-10', 2),
(2, '2002-02-10', 2),
(3, '2002-02-10', 2),
(4, '2002-02-10', 2);

INSERT INTO serie_genre VALUES (1, 2);

-- Acteurs films
INSERT INTO acteur_film
VALUES
(1, 1);

-- Acteurs épisodes
INSERT INTO acteur_episode
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(2, 5),
(2, 6),
(2, 7),
(2, 8);

-- Réalisateurs films
INSERT INTO realisateur_film
VALUES
(1, 1);

-- Réalisateurs épisodes
INSERT INTO realisateur_episode
VALUES
(2, 1),
(2, 2),
(2, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(2, 8);


-- Utilisateurs
INSERT INTO utilisateur (uti_nom, uti_prenom, uti_pseudo, uti_password, uti_date_naissance)
VALUES
('P', 'J', 'jeremy', '123456', '1997-11-02');


-- Vionnages
INSERT INTO visionnage_episode (vise_duration, vise_utilisateur_id, vise_episode_id)
VALUES
(450, 1, 1),
(10, 1, 3);