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