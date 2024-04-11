CREATE TABLE FICHIER (
                         ID SERIAL PRIMARY KEY,
                         NOM VARCHAR(255) NOT NULL,
                         TYPE VARCHAR(5) NOT NULL
);

CREATE TABLE LIGNE (
                       ID SERIAL PRIMARY KEY,
                       PARAM1 INTEGER NOT NULL,
                       PARAM2 INTEGER NOT NULL,
                       OPERATEUR CHAR(1),
                       INDEX INTEGER NOT NULL,
                       FICHIER_ID INTEGER NOT NULL,
                       FOREIGN KEY (FICHIER_ID) REFERENCES FICHIER(ID)
);
