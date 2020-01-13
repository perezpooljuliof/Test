DELIMITER ;

DROP TABLE IF EXISTS PRODUCTO;

DELIMITER $$

CREATE TABLE PRODUCTO (
    IDProducto          INT             NOT NULL,
    Producto            VARCHAR(100)    NOT NULL,
    Costo               DECIMAL(10,2)   NOT NULL,
    Precio              DECIMAL(10,2)   NOT NULL,
    CodigoRapido        VARCHAR(10)     NOT NULL,
    CodigoBarras        VARCHAR(40)     NOT NULL,
    TipoVentaProd       CHAR(1)         NOT NULL,       -- U = Unidad/Pza, G = Granel
    EsGravable          CHAR(1)         NOT NULL,
    EsIEPS              CHAR(1)         NOT NULL,
    EsISH               CHAR(1)         NOT NULL,
    Estatus             CHAR(1)         NOT NULL,       -- Estatus (A = Activo, B = Baja)
    IDDepartamento      INT             NOT NULL,       -- ID del Departamento (Une con Tabla Departamento)
    CantidadMinima      DECIMAL(6,2)    NOT NULL,
    CantidadMaxima      DECIMAL(6,2)    NOT NULL,

    UUID                BIGINT(20)      NOT NULL,       -- Identificador de la transaccion
    FechaAct            DATETIME        NOT NULL,       -- Fecha y hora de la ultima actualizacion
    IDUsuario           INT             NOT NULL,       -- Ultimo usuario en realizar la actualizacion
    Programa            VARCHAR(70)     NOT NULL,       -- URL o programa que realiza la ultima actualizacion

    PRIMARY KEY(IdProducto)
)$$

ALTER TABLE PRODUCTO ADD INDEX (IDDepartamento)$$