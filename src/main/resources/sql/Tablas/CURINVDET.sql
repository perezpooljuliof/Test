DELIMITER ;

DROP TABLE IF EXISTS CURINVDET;

DELIMITER $$

CREATE TABLE CURINVDET (
    IDCurInvDet         INT             NOT NULL,
    IDCurInv            INT             NOT NULL,
    IDProducto          INT             NOT NULL,
    CodigoBarras        VARCHAR(40)     NOT NULL,
    Cantidad            DECIMAL(6,2)    NOT NULL,

    UUID                VARCHAR(50)     NOT NULL,       -- Identificador de la transaccion
    FechaAct            DATETIME        NOT NULL,       -- Fecha y hora de la ultima actualizacion
    IDUsuario           INT             NOT NULL,       -- Ultimo usuario en realizar la actualizacion

    PRIMARY KEY(IDCurInvDet),
    CONSTRAINT FK_CURINVDET_CURINV FOREIGN KEY(IDCurInv) REFERENCES CURINV(IDCurInv)
)$$