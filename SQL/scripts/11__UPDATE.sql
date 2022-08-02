-- Mettre à jour des informations (des colonnes) dans une table
UPDATE matable
SET col1 = 'Valeur 1',
    col2 = 'Valeur 2'
WHERE col3 = 'X'; -- Sans restriction, toutes les lignes se mettent à jour


-- Exemple
UPDATE client SET cli_age = 30; -- Tous les clients auront 30 ans
UPDATE client SET cli_age = 32 WHERE cli_id = 1; -- Seul le client #1 aura son age modifié


-- Faire un backup
CREATE TABLE backup_client AS
SELECT * FROM client;

-- Supprimer la table de backup
DROP TABLE backup_client;


-- Mettre à jour les prix de vente des produits = prix d'achat * 2.5
UPDATE produit
SET pro_prix_vente = pro_prix_achat * 2.5;

SELECT * FROM produit;

-- Changer l'état des commandes dont la date est avant le 25/11/2021 -> état 5
UPDATE commande
SET cmd_etat = 5
WHERE cmd_date < '2021-11-25';

SELECT * FROM commande;

-- Mettre à jour les notes des produits
SELECT AVG(com_note) FROM commentaire WHERE com_produit_id = 1;

UPDATE produit
SET pro_note = COALESCE((SELECT AVG(com_note) FROM commentaire WHERE com_produit_id = pro_id), -1);

SELECT * FROM produit;