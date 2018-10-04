DELIMITER ;

DROP TABLE IF EXISTS CURINV;

DELIMITER $$

CREATE TABLE CURINV (
    IDCurInv            INT             NOT NULL,
    IDAlmacen           INT             NOT NULL,

    UUID                VARCHAR(50)     NOT NULL,       -- Identificador de la transaccion
    FechaAct            DATETIME        NOT NULL,       -- Fecha y hora de la ultima actualizacion
    IDUsuario           INT             NOT NULL,       -- Ultimo usuario en realizar la actualizacion

    PRIMARY KEY(IDCurInv),
    CONSTRAINT FK_CURINV_ALMACEN FOREIGN KEY(IDAlmacen) REFERENCES ALMACEN(IDAlmacen)
)$$