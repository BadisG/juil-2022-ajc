-- DDL => Data Definition Language : Définition de la structure des données (base & les tables)

-- CREATE : Créer (nouvelle base de données, une nouvelle table, etc.)

-- Création d'une base de données
CREATE DATABASE nom_base;

-- Création d'une table
CREATE TABLE nom_table (liste_des_colonnes_avec_leur_type_et_les_options);

-- Création d'une table (exemple)
CREATE TABLE nom_table (
    nom_colonne TYPE_DONNEE OPTIONS,
    -- cli_id INT NOT NULL AUTO_INCREMENT -- MySQL / MariaDB
    cli_id SERIAL, -- INT AUTO_INCREMENTE
    cli_nom VARCHAR(100) NOT NULL,
    cli_email VARCHAR(150) NOT NULL DEFAULT 'zoulou@gmail.com',
    PRIMARY KEY (cli_id) -- Clé primaire sur la colonne cli_id
);

CREATE TABLE nom_table (
    cli_id SERIAL PRIMARY KEY, -- INT AUTO_INCREMENTE CLE PRIMAIRE
    cli_nom VARCHAR(100) NOT NULL,
    cli_email VARCHAR(150) NOT NULL DEFAULT 'zoulou@gmail.com',
);

-- Types de données
-- SERIAL           -> Entier auto-incrémenté géré par PostgreSQL
-- INT              -> Entier
-- BIT / BOOLEAN    -> Booléen
-- VARCHAR(n)       -> Chaine de caractères de N caractères maxi
-- CHAR(n)          -> Chaine de caractères de N caractères
-- TEXT             -> Longue chaine de caractères (8000 caractères)
-- LONGTEXT         -> Le double d'une longue chaine de caractères
-- DATE             -> Date
-- TIME             -> Heure
-- DATETIME         -> Date & Heure
-- TIMESTAMP        -> Date & Heure (à partir du 01/01/1970)
-- FLOAT            -> Chiffre à virgule
-- NUMERIC          -> Chiffre à virgule
-- DECIMAL(n, m)    -> Chiffre à virgule
--                      n => nombre de chiffres au total
--                      m => nombre de chiffres après la virgule
--                      DECIMAL(10, 2) : 10 chiffres au max, dont 2 utilisés pour la virgule

-- NULL             -> Valeur NULL possible
-- NOT NULL         -> Valeur NULL impossible


-- Table réparateur
-- rep_id (auto_incrémenté, clé primaire)
-- rep_nom (100 caractères maxi - pas null)
-- rep_tel (20 caractères maxi - nullable)
-- rep_description (texte sans caractères maxi - nullable)
CREATE TABLE reparateur (
    rep_id SERIAL PRIMARY KEY,
    rep_nom VARCHAR(100) NOT NULL,
    rep_tel VARCHAR(20) NULL,
    rep_description TEXT -- Nullable par défaut
);

-- Insérer d'un réparateur
INSERT INTO reparateur (rep_nom, rep_tel) VALUES ('Super reparator', '0153421575');

-- Sélection des réparateurs
SELECT * FROM reparateur;


-- DROP : Supprimer une base de donneés, une table, etc.

-- Supprimer une base de données
DROP DATABASE nom_base;

-- Supprimer une table
DROP TABLE nom_table;



-- ALTER : Altérer / Modifier (base de données, une table, etc.)

-- Modifier une base de données
ALTER DATABASE nom_base ....;

-- Modifier une table
ALTER TABLE nom_table ....;

-- Modifier une table : ajouter une colonne
ALTER TABLE nom_table
    ADD COLUMN nom_colonne TYPE OPTIONS;

-- Modifier une table : supprimer une colonne
ALTER TABLE nom_table
    DROP COLUMN nom_colonne;

-- Modifier une table : ajouter une contrainte
ALTER TABLE nom_table
    ADD CONSTRAINT nom_contrainte OPTIONS;

-- Modifier une table : supprimer une contrainte
ALTER TABLE nom_table
    DROP CONSTRAINT nom_contrainte;



-- Supprimer la colonne cli_age de client
ALTER TABLE client
    DROP COLUMN cli_age;

-- Ajouter une colonne à la table produit : pro_reparateur_id (qui fera référence à l'id rep)
ALTER TABLE produit
    ADD COLUMN pro_reparateur_id INT NULL;

-- Ajouter une contrainte à la table reperateur "chk_telephone"
-- > sur la colonne rep_tel
-- > CHECK (rep_tel ~ '[0-9]{10}')
ALTER TABLE reparateur
    ADD CONSTRAINT chk_telephone
    CHECK (rep_tel ~ '[0-9]{10}');  -- tild (~) permet de vérifier un pattern regex ('[0-9]{10}')
                                    -- [0-9] : chiffre de 0 à 9
                                    -- {10} : 10 chiffres de 0 à 9


-- Ajouter une contrainte de clé étrangère entre pro_reparateur_id (produit) et rep_id (reparateur)
-- > Foreign Key (Clé étrangere)
ALTER TABLE produit
    ADD CONSTRAINT FK_ProduitReparateur
    FOREIGN KEY (pro_reparateur_id) -- Colonne clé étrangère dans la table produit
    REFERENCES reparateur (rep_id) -- Colonne clé primaire dans la table reparateur

    -- Ajout des options à cette contrainte
    ON DELETE CASCADE -- Supprimer en cascade les produits qui font référence au réparateur qui sera supprimé
    ON UPDATE RESTRICT -- (ou NO ACTION) Empêche la mise à jour l'id du réparateur dans la table produit
    ;
-- Par défaut, NO ACTION, donc pas de suppression en cascade, ni de mise à jour en cascade