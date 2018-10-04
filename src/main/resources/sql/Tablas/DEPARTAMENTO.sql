DELIMITER ;

DROP TABLE IF EXISTS DEPARTAMENTO;

DELIMITER $$

CREATE TABLE DEPARTAMENTO (
    IDDepartamento       INT             NOT NULL,
    IDEmpresa            INT             NOT NULL,
    Departamento         VARCHAR(50)     NOT NULL,

    UUID            VARCHAR(50)     NOT NULL,       -- Identificador de la transaccion
    FechaAct        DATETIME        NOT NULL,       -- Fecha y hora de la ultima actualizacion
    IDUsuario       INT             NOT NULL,       -- Ultimo usuario en realizar la actualizacion

    PRIMARY KEY(IDDepartamento),
    CONSTRAINT FK_DEPTO_EMPRESA FOREIGN KEY(IDEmpresa) REFERENCES EMPRESA(IDEmpresa)
)$$