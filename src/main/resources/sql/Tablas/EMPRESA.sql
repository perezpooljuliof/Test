DELIMITER ;

DROP TABLE IF EXISTS EMPRESA;

DELIMITER $$

CREATE TABLE EMPRESA (
    IDEmpresa       INT             NOT NULL,
    Nombre          VARCHAR(100)    NOT NULL,
    RFC             VARCHAR(30)     NOT NULL,

    UUID            VARCHAR(50)     NOT NULL,       -- Identificador de la transaccion
    FechaAct        DATETIME        NOT NULL,       -- Fecha y hora de la ultima actualizacion
    IDUsuario       INT             NOT NULL,       -- Ultimo usuario en realizar la actualizacion

    PRIMARY KEY(IDEmpresa)
)$$