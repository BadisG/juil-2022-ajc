-- Faire en sorte qu'un client puisse avoir plusieurs adresses
-- > rue, ville, code postal
CREATE TABLE adresse (
    adr_id SERIAL PRIMARY KEY,
    adr_rue VARCHAR(200) NOT NULL,
    adr_ville VARCHAR(100) NULL,
    adr_code_postal CHAR(5) NULL,
    adr_client_id INT NOT NULL,
    CONSTRAINT FK_AdresseClient
        FOREIGN KEY (adr_client_id)
        REFERENCES client (cli_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Fabriquer les adresses à partir des données connues
INSERT INTO adresse (adr_rue, adr_client_id)
SELECT cli_adresse, cli_id
FROM client
WHERE cli_adresse IS NOT NULL;

-- Supprimer la colonne cli_adresse
ALTER TABLE client
    DROP COLUMN cli_adresse;


-- Oups, on a oublié de mettre le numéro de tél dans l'adresse
ALTER TABLE adresse
    ADD COLUMN adr_telephone VARCHAR(20);

UPDATE adresse
SET adr_telephone = (SELECT cli_numero_telephone FROM client WHERE cli_id = adr_client_id);

SELECT * FROM adresse;

ALTER TABLE client
    DROP COLUMN cli_numero_telephone;