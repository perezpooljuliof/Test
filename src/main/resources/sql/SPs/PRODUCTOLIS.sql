DELIMITER ;

DROP PROCEDURE IF EXISTS PRODUCTOLIS;

DELIMITER $$

CREATE PROCEDURE PRODUCTOLIS (
	-- Stored procedure para lista los Productos
	Par_IDProducto              INT,                -- ID del Producto
	Par_Producto                VARCHAR(100),       -- Nombre del Producto
    Par_Costo                   DECIMAL(10,2),      -- Costo
    Par_Precio                  DECIMAL(10,2),      -- Precio
    Par_Codigo                  VARCHAR(40),        -- Codigo de Barras
    Par_TipoVentaProd           CHAR(1),            -- Tipo de Venta del producto (U = Unidad/Pza, G = Granel)
    Par_EsGravable              CHAR(1),            -- Es Gravable
    Par_EsIEPS                  CHAR(1),            -- Es IEPS
    Par_EsISH                   CHAR(1),            -- Es ISH
    Par_Estatus                 CHAR(1),            -- Estatus del producto (Alta por defecto)
    Par_IDDepartamento          INT,                -- ID del Departamento
    Par_CantidadMinima          DECIMAL(6,2),       -- Cantidad minima
    Par_CantidadMaxima          DECIMAL(6,2),       -- Cantidad maxima

    Par_NumOpcion               INT,                -- Numero de lista

    Par_UUID                    VARCHAR(50),        -- Identificador de la transaccion
    Par_IDUsuario               INT                 -- Ultimo usuario en realizar la actualizacion
)
BEGIN
    -- Lista completa de productos activos (A)
    IF(Par_NumOpcion = 1) THEN
        SELECT  IDProducto,         Producto,           Costo,              Precio
            FROM PRODUCTO
            WHERE Estatus = 'A'
            ORDER BY Producto, Costo;
    END IF;
END$$