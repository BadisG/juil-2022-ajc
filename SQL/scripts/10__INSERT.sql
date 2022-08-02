-- Insérer une nouvelle donnée (une nouvelle ligne - un nouvel enregistrement)
INSERT INTO matable (col1, col2, col3) VALUES ('Valeur 1', 'Valeur 2', 'Valeur 3');

-- Insérer plusieurs données
INSERT INTO matable (col1, col2, col3)
VALUES
('Valeur 1', 'Valeur 2', 'Valeur 3'),
('Valeur 1', 'Valeur 2', 'Valeur 3'),
('Valeur 1', 'Valeur 2', 'Valeur 3'),
('Valeur 1', 'Valeur 2', 'Valeur 3');


-- Attention au format
-- > Dates : 'année-mois-jour heure:minute:seconde.ms'
-- -> '2022-08-02 14:10' | '2022-08-02'

-- > Entiers : '5' ou 5
-- > Flottants : '5.6' ou 5.6

-- > Textes avec apostrophes, "l'été indien"
-- -> 'l''été indien' (PostgreSQL)
-- -> 'l\'été indien' (MySQL, MariaDB, MSSQL)



-- Insérer un nouveau client
INSERT INTO client (cli_nom, cli_prenom, cli_email) VALUES ('LE', 'Client', 'leclient@gmail.com');

SELECT * FROM client;

-- Insérer un nouveau commentaire (en prenant le nouveau client)
INSERT INTO commentaire (com_note, com_commentaire, com_produit_id, com_client_id)
VALUES					(4,			'Super',		1,				6);


INSERT INTO commentaire (com_note, com_commentaire, com_produit_id, com_client_id)
VALUES					(4,			'Super 2',		1,				(SELECT MAX(cli_id) FROM client));

SELECT * FROM commentaire;

-- Insérer une nouvelle commande (avec le dernier client)
INSERT INTO commande (cmd_client_id) VALUES (6);

SELECT * FROM commande;

-- Insérer deux nouveaux achats (avec la dernière commande, et 2 produits au hasard)
INSERT INTO achat (ach_montant, ach_quantite, ach_commande_id, ach_produit_id)
VALUES
(440, 1, 5, 1), -- 440 euros, 1 fois, commande #5, produit #1
(1500, 2, 5, 5); -- 1500 euros, 2 fois, commande #5, produit #5

INSERT INTO achat(ach_montant, ach_quantite, ach_commande_id, ach_produit_id)
SELECT pro_prix_vente, 1, 5, pro_id
FROM produit
WHERE pro_id IN (1, 5);

SELECT * FROM achat;