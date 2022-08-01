SELECT *
FROM produit;

SELECT *
FROM fournisseur;

-- Produit cartésien des 2 tables : chaque produit est associé à tous les fournisseurs
SELECT *
FROM produit, fournisseur;

-- Pour une jointure, on va prendre le produit cartésien,
-- et faire une restriction dessus : lorsque l'id du fournisseur du produit = l'id du fournisseur
SELECT *
FROM produit, fournisseur
WHERE pro_fournisseur_id = fou_id;

-- Avec une "vraie" jointure SQL
SELECT *
FROM produit
INNER JOIN fournisseur ON fou_id = pro_fournisseur_id;



-- Sélectionner la note (commentaire) avec le nom du client qui a noté
SELECT
    com_note,
    cli_nom
FROM commentaire
INNER JOIN client ON cli_id = com_client_id;

-- Sélectionner la note (commentaire) avec le nom du produit noté
SELECT com_note, pro_nom
FROM commentaire
INNER JOIN produit ON pro_id = com_produit_id;

-- Sélectionner la note (commentaire) avec le nom du produit noté et le nom du client qui a noté
SELECT com_note, pro_nom, cli_nom
FROM commentaire
RIGHT JOIN client ON cli_id = com_client_id
INNER JOIN produit ON pro_id = com_produit_id;


-- Exemples LEFT & RIGHT
SELECT com_note, cli_nom
FROM commentaire
RIGHT JOIN client ON cli_id = com_client_id;
-- STRICTEMENT IDENTIQUES
SELECT com_note, cli_nom
FROM client
LEFT JOIN commentaire ON cli_id = com_client_id;



-- Sélectionner le nom du produit avec le nom du fournisseur
SELECT pro_nom, fou_nom
FROM produit
INNER JOIN fournisseur ON fou_id = pro_fournisseur_id;

-- Sélectionner la date de la commande avec le nom du client
SELECT cmd_date, cli_nom
FROM commande
INNER JOIN client ON cli_id = cmd_client_id;

-- Sélectionner tous les produits (nom du produit), avec leur note si disponible
SELECT pro_nom, com_note
FROM produit
LEFT JOIN commentaire ON com_produit_id = pro_id;



-- Sélectionner tous les clients et leurs achats (nom du client, prenom du client, date de commande, id produit acheté [+ nom du produit acheté])
-- nom du client, prénom 	-> table client
-- date de commande		    -> table commande
-- id du produit acheté	    -> table achat
-- nom du produit			-> table produit

SELECT
    cli_nom,
    cli_prenom,
    cmd_date,
    ach_produit_id
FROM client
INNER JOIN commande ON cmd_client_id = cli_id
INNER JOIN achat ON ach_commande_id = cmd_id;

SELECT
    cli_nom,
    cli_prenom,
    cmd_date,
    pro_id, -- ou ach_produit_id, puisque c'est les mêmes infos
    pro_nom
FROM client
INNER JOIN commande ON cmd_client_id = cli_id
INNER JOIN achat ON ach_commande_id = cmd_id
INNER JOIN produit ON pro_id = ach_produit_id;


-- Sélectionner tous les clients qui n'ont pas d'achat (nom du client, prenom du client)
SELECT cli_nom, cli_prenom
FROM client
LEFT JOIN commande ON cmd_client_id = cli_id
WHERE cmd_id IS NULL;


-- Sélectionner les 2 derniers achats (date d'achat, nom du client, nom du produit, nom du fournisseur, note)
-- > Avec les informations client, produit, fournisseur et éventuellement sa note
SELECT
    ach_date,
    cli_nom,
    pro_nom,
    fou_nom,
    com_note

-- On part de la table achat
FROM achat

-- On va chercher les informations du client ... on passe par la table commande
INNER JOIN commande ON cmd_id = ach_commande_id
INNER JOIN client ON cli_id = cmd_client_id

-- On va chercher les infos du produit
INNER JOIN produit ON pro_id = ach_produit_id

-- On va chercher les infos du fournisseurs
INNER JOIN fournisseur ON fou_id = pro_fournisseur_id

-- On va chercher les infos du commentaire éventuel
LEFT JOIN commentaire ON com_produit_id = pro_id

-- On tri sur la date décroissante
ORDER BY ach_date DESC

-- On prend les 2 premiers résultats
LIMIT 2;