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

-- Compter les commandes par client, et afficher le nb, le nom et le prénom du client

-- Afficher le nom du produit, le prix de vente d'un produit avec sa promotion (prixvente - montant promo)
-- > Afficher tous les prix de tous les produits

-- Afficher le nom du client et son / ses commentaires (commentaire, et la note)

-- Compter le nombre de commentaire pour chaque client, avec le nom du client

-- Lister les produits (nom, prix de vente)
-- > Dont le prix de vente est inférieur au prix vendu (montant de achat)
