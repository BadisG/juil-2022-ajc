-- Le nombre de commandes
SELECT COUNT(cmd_id) FROM commande;

-- Le nombre de commandes pour chaque client_id
SELECT
    COUNT(cmd_id),
    cmd_client_id
FROM commande
GROUP BY cmd_client_id;

-- Le nombre de commandes pour chaque client_id (avec son nom)
SELECT
    COUNT(cmd_id),
    cli_nom
FROM commande
INNER JOIN client ON cli_id = cmd_client_id
GROUP BY cli_id;


-- Le nombre de commandes pour chaque client_id, et garder que les lignes dont le nombre est >= 2
SELECT
    COUNT(cmd_id),
    cmd_client_id
FROM commande
GROUP BY cmd_client_id
HAVING COUNT(cmd_id) >= 2;
