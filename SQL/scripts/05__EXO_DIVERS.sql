-- Lister le nom des produits
-- > leur prix d'achat
-- > leur prix de vente
-- > le delta entre prix vente et prix d'achat
-- > Seulement ceux qui ont un prix de vente > 500 euros
-- > Rangé par nom croissant
SELECT
    pro_nom,
    pro_prix_achat,
    pro_prix_vente,
    (pro_prix_vente - pro_prix_achat) AS delta
FROM produit
WHERE pro_prix_vente > 500
ORDER BY pro_nom;


-- Lister les 2 derniers achats (selon la date)
-- > Date, id commande
-- > Qui ont une promo
SELECT
    ach_date, ach_commande_id
FROM achat
WHERE ach_promo IS TRUE
ORDER BY ach_date DESC
LIMIT 2;


-- Lister le nom des produits
-- > leur prix d'achat
-- > leur prix de vente
-- > Qui ont un prix de vente >= 2 fois le prix d'achat
SELECT
    pro_nom,
    pro_prix_achat,
    pro_prix_vente
FROM produit
WHERE (pro_prix_vente / pro_prix_achat) >= 2;

SELECT
    pro_nom,
    pro_prix_achat,
    pro_prix_vente
FROM produit
WHERE pro_prix_vente >= (pro_prix_achat * 2);


-- Lister les achats
-- > l'id de la commande
-- > "OUI" si y'a une promo, "NON" si y'a pas de promo
SELECT
    ach_commande_id,
    CASE
        WHEN ach_promo IS TRUE THEN 'OUI'
        ELSE 'NON'
    END AS yesno
FROM achat;

SELECT
    ach_commande_id,
    CASE ach_promo
        WHEN TRUE THEN 'OUI'
        ELSE 'NON'
    END AS yesno
FROM achat;