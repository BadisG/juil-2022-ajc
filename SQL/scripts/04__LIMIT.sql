-- Quelques exemples
SELECT * FROM produit
LIMIT 2;

SELECT * FROM produit
OFFSET 0 LIMIT 2;

SELECT * FROM produit
OFFSET 2 LIMIT 2;


-- Sélectionner les 2 produits les moins cher (prix de vente)
SELECT * FROM produit
ORDER BY pro_prix_vente ASC
-- OFFSET 0
LIMIT 2;

-- Sélectionner les 2 suivants
SELECT * FROM produit
ORDER BY pro_prix_vente ASC
OFFSET 2 -- à partir du 3eme élément
LIMIT 2;