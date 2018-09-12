DELIMITER ;

DROP TABLE IF EXISTS PRODUCTO;

DELIMITER $$

CREATE TABLE PRODUCTO (
    IDProducto      INT             NOT NULL,
    Producto        VARCHAR(100)    NOT NULL,
    Costo           DECIMAL(10,2)   NOT NULL,
    Precio          DECIMAL(10,2)   NOT NULL,
    esGravable      CHAR(1)         NOT NULL,
    TipoVentaProd   CHAR(1)         NOT NULL,       -- U = Unidad/Pza, G = Granel
    esIEPS          CHAR(1)         NOT NULL,
    esISH           CHAR(1)         NOT NULL,

    UUID            VARCHAR(50)     NOT NULL,       -- Identificador de la transaccion
    FechaAct        DATETIME        NOT NULL,       -- Fecha y hora de la ultima actualizacion
    IDUsuario       INT             NOT NULL,       -- Ultimo usuario en realizar la actualizacion

    PRIMARY KEY(IdProducto)
)$$
