-- Supprimer des données
DELETE FROM matable; -- Il prend tous les enregistrements
DELETE FROM matable WHERE col = 'X'; -- On restreint les enregistrements à supprimer

-- Supprimer le client #1
DELETE FROM client WHERE cli_id = 1;

SELECT * FROM client;

-- Supprimer la promotion #1
DELETE FROM promotion WHERE pmt_id = 1;

SELECT * FROM promotion;