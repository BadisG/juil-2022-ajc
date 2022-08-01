-- Sélectionner tous les clients
SELECT * FROM client;

-- Sélectionner le nom et le prix de tous les produits
SELECT pro_nom, pro_prix_vente FROM produit;

-- Sélectionner toutes les commandes
SELECT * FROM commande;


-- Sélectionner tous les nom & prénom des clients dans une seule colonne
-- -> Les afficher en MAJUSCULES
SELECT UPPER(CONCAT(cli_nom, ' ', cli_prenom)) FROM client;

SELECT UPPER(cli_nom||' '||cli_prenom) FROM client;


-- Sélectionner le mois et l'année (mois-annee) des commandes
SELECT
	COALESCE(
		DATE_PART('MONTH', cmd_date)||'-'||DATE_PART('YEAR', cmd_date),
      	'0'
    )
FROM commande;

SELECT
	COALESCE(cmd_date, '2022-08-01')
FROM commande;

SELECT COALESCE('Test pas null', 'demo');
SELECT COALESCE(NULL, 'demo');