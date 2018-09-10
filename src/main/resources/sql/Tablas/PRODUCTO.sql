CREATE TABLE PRODUCTO (
    IdProducto INT NOT NULL AUTO_INCREMENT,
    Producto VARCHAR(100) NOT NULL,
    Costo DECIMAL(10,2) NOT NULL,
    Precio DECIMAL(10,2) NOT NULL,
    esGravable CHAR(1) NOT NULL,
    TipoVentaProd CHAR(1) NOT NULL,             -- U = Unidad/Pza, G = Granel
    esIEPS CHAR(1) NOT NULL,
    esISH CHAR(1) NOT NULL,

    PRIMARY KEY(IdProducto),
    CONSTRAINT FK_PRODUCTO_TIPODET FOREIGN KEY (IdTipoProducto) REFERENCES TIPODET (IdTipoDet)
);
