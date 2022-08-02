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

-- Supprimer la colonne cli_adresse