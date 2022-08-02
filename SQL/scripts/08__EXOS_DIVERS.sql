-- Nom et montant de toutes les promotions
SELECT pmt_nom, pmt_montant FROM promotion;

-- Nom et prénom du client #2
SELECT cli_nom, cli_prenom FROM client WHERE cli_id = 2;

-- Nom, prix d'achat, prix de vente du produit #1
SELECT pro_nom, pro_prix_achat, pro_prix_vente FROM produit WHERE pro_id = 1;

-- Nom du fournisseur #1 et noms de ses produits
SELECT
    fou_nom,
    pro_nom
FROM fournisseur
LEFT JOIN produit ON pro_fournisseur_id = fou_id
WHERE fou_id = 1;

-- Compter le nombre de promotions
SELECT COUNT(pmt_id) AS nb FROM promotion;

-- Le nombre de commandes pour chaque client_id trié par nombre décroissant
SELECT
    COUNT(cmd_id) AS nb,
    cmd_client_id
FROM commande
GROUP BY cmd_client_id
-- ORDER BY 1 DESC
ORDER BY nb DESC
;

-- Nombre de produits par fournisseur (nom fournisseur et nb produits)
SELECT
    COUNT(pro_id) AS nb,
    fou_nom
FROM produit
RIGHT JOIN fournisseur ON fou_id = pro_fournisseur_id
GROUP BY fou_id;

SELECT
    COUNT(pro_id) AS nb,
    fou_nom
FROM fournisseur
LEFT JOIN produit ON fou_id = pro_fournisseur_id
GROUP BY fou_id;

-- Somme de tous les montants (des achats)
SELECT SUM(ach_montant * ach_quantite) FROM achat;

-- Moyenne des prix de vente des produits
SELECT AVG(pro_prix_vente) FROM produit;

-- Montant minimum des achats
SELECT MIN(ach_montant * ach_quantite) FROM achat;

-- Prix de vente maximum des produits
SELECT MAX(pro_prix_vente) FROM produit;





-- Première date de commande, dernière date de commande
SELECT MIN(cmd_date) premiereDate, MAX(cmd_date) derniereDate FROM commande;

-- Compter les commandes par client, et afficher le nb, le nom et le prénom du client
SELECT
    cli_nom,
    cli_prenom,
    COUNT(cmd_id)
FROM client
LEFT JOIN commande ON cmd_client_id = cli_id
-- GROUP BY cli_nom, cli_prenom
GROUP BY cli_id
;

-- Afficher le nom du produit, le prix de vente d'un produit avec sa promotion (prixvente - montant promo)
-- > Afficher tous les prix de tous les produits
SELECT
    pro_nom,
    (pro_prix_vente - COALESCE(pmt_montant, 0)) AS solution1,
    COALESCE((pro_prix_vente - pmt_montant), pro_prix_vente) AS solution2
FROM produit
LEFT JOIN promotion ON pmt_produit_id = pro_id;

-- Afficher le nom du client et son / ses commentaires (commentaire, et la note)
SELECT
    cli_nom,
    com_commentaire,
    com_note
FROM client
INNER JOIN commentaire ON com_client_id = cli_id;

-- Compter le nombre de commentaire pour chaque client, avec le nom du client
SELECT
    cli_nom,
    COUNT(com_id) AS nb
FROM client
LEFT JOIN commentaire ON com_client_id = cli_id;


-- Lister les produits (nom, prix de vente)
-- > Dont le prix de vente est inférieur au prix vendu (montant de achat)
SELECT
    pro_nom,
    pro_prix_vente
FROM produit
INNER JOIN achat ON ach_produit_id = pro_id
WHERE pro_prix_vente < ach_montant;


-- Calculer par ID commande le CA (montant * quantite)
-- > Ne garder QUE les CA > 500 euros
SELECT SUM(ach_montant * ach_quantite) AS ca
FROM achat
GROUP BY ach_commande_id
HAVING SUM(ach_montant * ach_quantite) > 500;

-- Sélectionner tous les clients (nom, prénom) avec leur CA (montant achat * quantite)
-- > Ranger par CA décroissant
-- > Tous les clients, si CA inexistant : afficher 0 (COALESCE)
SELECT
    cli_nom,
    cli_prenom,
    COALESCE(
      SUM(ach_montant * ach_quantite),
      0 -- Afficher 0 si la somme est NULL
    ) AS ca -- Renommer la colonne
FROM client
LEFT JOIN commande ON cmd_client_id = cli_id
LEFT JOIN achat ON ach_commande_id = cmd_id
GROUP BY cli_id
ORDER BY ca DESC;

-- Sélectionner les clients dont le CA est > 0
-- > En ne prenant en compte QUE les produits qui ont une note > 4
-- > Afficher le nom du client, le prénom, le CA et la note
SELECT
	cli_nom,
    cli_prenom,
    SUM(ach_montant * ach_quantite) AS ca,
    AVG(com_note) AS note
FROM client
INNER JOIN commande ON cmd_client_id = cli_id
INNER JOIN achat ON ach_commande_id = cmd_id
INNER JOIN commentaire ON com_produit_id = ach_produit_id
GROUP BY cli_id
HAVING
	SUM(ach_montant * ach_quantite) > 0
    AND
    AVG(com_note) > 4;
