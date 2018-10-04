DELIMITER ;

DROP TABLE IF EXISTS IMAGEN;

DELIMITER $$

CREATE TABLE IMAGEN (
    IDImagen            INT             NOT NULL,
    Nombre              VARCHAR(50)     NOT NULL,
    URL                 VARCHAR(150)    NOT NULL,
    NombreArchivo       VARCHAR(50)     NOT NULL,

    PRIMARY KEY(IDImagen)
)$$
