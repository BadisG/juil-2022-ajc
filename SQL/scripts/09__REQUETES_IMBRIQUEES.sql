SELECT
	blabla, (SELECT blabla)
FROM (SELECT blabla)
INNER JOIN (SELECT blabla)
WHERE machine = (SELECT blabla)

-- Requête imbriquée au niveau du SELECT 	-> doit retourner UNE SEULE COLONNE, et UN SEUL RESULTAT
-- Requête imbriquée au niveau du WHERE 	-> doit retourner UNE SEULE COLONNE
-- Requête imbriquée au niveau d'une tableu	-> pas de restriction


SELECT DISTINCT cmd_client_id FROM commande;

-- Clients qui n'ont pas commandé
SELECT * FROM client WHERE cli_id NOT IN (1, 2, 3);

-- Clients qui n'ont pas commandé
SELECT * FROM client WHERE cli_id NOT IN (SELECT DISTINCT cmd_client_id FROM commande);

-- Nom du client AVEC sa premiere date de commande et sa dernière date de commande
SELECT
	cli_nom,
    (SELECT MIN(cmd_date) FROM commande WHERE cmd_client_id = cli_id) AS premiereDate,
    (SELECT MAX(cmd_date) FROM commande WHERE cmd_client_id = cli_id) AS derniereDate
FROM client;


-- Afficher le nom du produit et son prix moyen de vente (montant de l'achat)
SELECT AVG(ach_montant) FROM achat WHERE ach_produit_id = 2;
SELECT SUM(ach_montant * ach_quantite) / SUM(ach_quantite) FROM achat WHERE ach_produit_id = 2;

SELECT
	pro_nom,
    (SELECT AVG(ach_montant) FROM achat WHERE ach_produit_id = pro_id) AS prixMoyen
FROM produit;


-- La commande du client qui a l'identifiant le plus petit (afficher id & date commande)
SELECT MIN(cli_id) FROM client;
SELECT * FROM commande WHERE cmd_client_id = 1;

SELECT cmd_id, cmd_date
FROM commande
WHERE cmd_client_id = (SELECT MIN(cli_id) FROM client);


-- Les achats du produit qui a le prix de vente (de la table produit) le plus grand
SELECT MAX(pro_prix_vente) FROM produit;

-- Solution 1
SELECT pro_id FROM produit ORDER BY pro_prix_vente DESC LIMIT 1;

-- Solution 2
SELECT pro_id FROM produit WHERE pro_prix_vente = (SELECT MAX(pro_prix_vente) FROM produit);


SELECT * FROM achat;


-- Solution 1
SELECT *
FROM achat
WHERE ach_produit_id = (SELECT pro_id FROM produit ORDER BY pro_prix_vente DESC LIMIT 1);

-- Solution 2
SELECT *
FROM achat
WHERE ach_produit_id = (
  SELECT pro_id FROM produit WHERE pro_prix_vente = (
    SELECT MAX(pro_prix_vente) FROM produit
  )
);