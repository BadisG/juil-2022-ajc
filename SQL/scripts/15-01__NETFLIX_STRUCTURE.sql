-- Création de la base de données
CREATE DATABASE netflix;

-- Enumerateur
CREATE TYPE nationalite AS ENUM ('FR', 'EN', 'DE');

-- Table acteur
CREATE TABLE acteur (
    act_id SERIAL PRIMARY KEY,
    act_nom VARCHAR(100) NOT NULL,
    act_prenom VARCHAR(100) NOT NULL,
    act_nationalite nationalite NOT NULL DEFAULT 'FR',
    act_date_naissance DATE NOT NULL
);

-- Table réalisateur
CREATE TABLE realisateur (
    real_id SERIAL PRIMARY KEY,
    real_nom VARCHAR(100) NOT NULL,
    real_prenom VARCHAR(100) NOT NULL,
    real_nationalite nationalite NOT NULL DEFAULT 'FR',
    real_date_naissance DATE NOT NULL
);

-- Table genre
CREATE TABLE genre (
    gen_id SERIAL PRIMARY KEY,
    gen_nom VARCHAR(100) NOT NULL
);

-- Table film
CREATE TABLE film (
    film_id SERIAL PRIMARY KEY,
    film_nom VARCHAR(100) NOT NULL,
    film_date_sortie DATE NOT NULL
);

-- Table film / genre
CREATE TABLE film_genre (
    fige_film_id INT NOT NULL,
    fige_genre_id INT NOT NULL,
    PRIMARY KEY (fige_film_id, fige_genre_id)
);

-- Table acteur / film
CREATE TABLE acteur_film (
    acfi_acteur_id INT NOT NULL,
    acfi_film_id INT NOT NULL,
    PRIMARY KEY (acfi_acteur_id, acfi_film_id)
);

-- Table réalisateur / film
CREATE TABLE realisateur_film (
    refi_realisateur_id INT NOT NULL,
    refi_film_id INT NOT NULL,
    PRIMARY KEY (refi_realisateur_id, refi_film_id)
);


-- Table série
CREATE TABLE serie (
    ser_id SERIAL PRIMARY KEY,
    ser_nom VARCHAR(100) NOT NULL,
    ser_date_sortie DATE NOT NULL,
    ser_saisons INT NOT NULL DEFAULT 1
);

-- Table serie / genre
CREATE TABLE serie_genre (
    sege_serie_id INT NOT NULL,
    sege_genre_id INT NOT NULL,
    PRIMARY KEY (sege_serie_id, sege_genre_id)
);

-- Table saison
CREATE TABLE saison (
    sai_id SERIAL PRIMARY KEY,
    sai_numero INT NOT NULL DEFAULT 1,
    sai_date_sortie DATE NOT NULL,
    sai_episodes INT NOT NULL DEFAULT 1,
    sai_serie_id INT NOT NULL
);

-- Table episode
CREATE TABLE episode (
    epi_id SERIAL PRIMARY KEY,
    epi_numero INT NOT NULL DEFAULT 1,
    epi_date_sortie DATE NOT NULL,
    epi_saison_id INT NOT NULL
);

-- Table acteur / épisode
CREATE TABLE acteur_episode (
    acep_acteur_id INT NOT NULL,
    acep_episode_id INT NOT NULL,
    PRIMARY KEY (acep_acteur_id, acep_episode_id)
);

-- Table réalisateur / épisode
CREATE TABLE realisateur_episode (
    reep_realisateur_id INT NOT NULL,
    reep_episode_id INT NOT NULL,
    PRIMARY KEY (reep_realisateur_id, reep_episode_id)
);


-- Table utilisateur
CREATE TABLE utilisateur (
    uti_id SERIAL PRIMARY KEY,
    uti_nom VARCHAR(100) NOT NULL,
    uti_prenom VARCHAR(100) NOT NULL,
    uti_pseudo VARCHAR(50) NOT NULL,
    uti_password TEXT NOT NULL,
    uti_date_naissance DATE NOT NULL
);

-- Table visionnage film
CREATE TABLE visionnage_film (
    visf_id SERIAL PRIMARY KEY,
    visf_duration BIGINT NOT NULL DEFAULT 0,
    visf_utilisateur_id INT NOT NULL,
    visf_film_id INT NOT NULL
);

-- Table visionnage épisode
CREATE TABLE visionnage_episode (
    vise_id SERIAL PRIMARY KEY,
    vise_duration BIGINT NOT NULL DEFAULT 0,
    vise_utilisateur_id INT NOT NULL,
    vise_episode_id INT NOT NULL
);



-- Clé étrangère : FilmGenre -> Film
ALTER TABLE film_genre
    ADD CONSTRAINT FK_FilmGenreFilm
        FOREIGN KEY (fige_film_id)
        REFERENCES film (film_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

-- Clé étrangère : FilmGenre -> Genre
ALTER TABLE film_genre
    ADD CONSTRAINT FK_FilmGenreGenre
        FOREIGN KEY (fige_genre_id)
        REFERENCES genre (gen_id);

-- Clé étrangère : SerieGenre -> Serie
ALTER TABLE serie_genre
    ADD CONSTRAINT FK_SerieGenreSerie
        FOREIGN KEY (sege_serie_id)
        REFERENCES serie (ser_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

-- Clé étrangère : SerieGenre -> Genre
ALTER TABLE serie_genre
    ADD CONSTRAINT FK_SerieGenreGenre
        FOREIGN KEY (sege_genre_id)
        REFERENCES genre (gen_id);


-- Clé étrangère : ActeurFilm -> Acteur
ALTER TABLE acteur_film
    ADD CONSTRAINT FK_ActeurFilmActeur
        FOREIGN KEY (acfi_acteur_id)
        REFERENCES acteur (act_id);

-- Clé étrangère : ActeurFilm -> Film
ALTER TABLE acteur_film
    ADD CONSTRAINT FK_ActeurFilmFilm
        FOREIGN KEY (acfi_film_id)
        REFERENCES film (film_id);


-- Clé étrangère : ActeurEpisode -> Acteur
ALTER TABLE acteur_episode
    ADD CONSTRAINT FK_ActeurEpisodeActeur
        FOREIGN KEY (acep_acteur_id)
        REFERENCES acteur (act_id);

-- Clé étrangère : ActeurEpisode -> Episode
ALTER TABLE acteur_episode
    ADD CONSTRAINT FK_ActeurEpisodeEpisode
        FOREIGN KEY (acep_episode_id)
        REFERENCES episode (epi_id);


-- Clé étrangère : RealisateurFilm -> Realisateur
ALTER TABLE realisateur_film
    ADD CONSTRAINT FK_RealisateurFilmRealisateur
        FOREIGN KEY (refi_realisateur_id)
        REFERENCES realisateur (real_id);

-- Clé étrangère : RealisateurFilm -> Film
ALTER TABLE realisateur_film
    ADD CONSTRAINT FK_RealisateurFilmFilm
        FOREIGN KEY (refi_film_id)
        REFERENCES film (film_id);


-- Clé étrangère : RealisateurEpisode -> Realisateur
ALTER TABLE realisateur_episode
    ADD CONSTRAINT FK_RealisateurEpisodeRealisateur
        FOREIGN KEY (reep_realisateur_id)
        REFERENCES realisateur (real_id);

-- Clé étrangère : RealisateurEpisode -> Episode
ALTER TABLE realisateur_episode
    ADD CONSTRAINT FK_RealisateurEpisodeEpisode
        FOREIGN KEY (reep_episode_id)
        REFERENCES episode (epi_id);


-- Clé étrangère : Saison -> Série
ALTER TABLE saison
    ADD CONSTRAINT FK_SaisonSerie
        FOREIGN KEY (sai_serie_id)
        REFERENCES serie (ser_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;

-- Clé étrangère : Episode -> Saison
ALTER TABLE episode
    ADD CONSTRAINT FK_EpisodeSaison
        FOREIGN KEY (epi_saison_id)
        REFERENCES saison (sai_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE;


-- Clé étrangère : VisionnageFilm -> Utilisateur
ALTER TABLE visionnage_film
    ADD CONSTRAINT FK_VisionnageFilmUtilisateur
        FOREIGN KEY (visf_utilisateur_id)
        REFERENCES utilisateur (uti_id);

-- Clé étrangère : VisionnageFilm -> Film
ALTER TABLE visionnage_film
    ADD CONSTRAINT FK_VisionnageFilmFilm
        FOREIGN KEY (visf_film_id)
        REFERENCES film (film_id);

-- Clé étrangère : VisionnageEpisode -> Utilisateur
ALTER TABLE visionnage_episode
    ADD CONSTRAINT FK_VisionnageEpisodeUtilisateur
        FOREIGN KEY (vise_utilisateur_id)
        REFERENCES utilisateur (uti_id);

-- Clé étrangère : VisionnageEpisode -> Episode
ALTER TABLE visionnage_episode
    ADD CONSTRAINT FK_VisionnageEpisodeEpisode
        FOREIGN KEY (vise_episode_id)
        REFERENCES episode (epi_id);