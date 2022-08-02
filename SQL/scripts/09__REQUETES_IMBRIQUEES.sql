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