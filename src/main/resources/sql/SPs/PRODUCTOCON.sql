DELIMITER ;

DROP PROCEDURE IF EXISTS PRODUCTOCON;

DELIMITER $$

CREATE PROCEDURE PRODUCTOCON (
	-- Stored procedure para consultar un producto
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

    Par_NumOpcion               INT,                -- Numero de consulta

    Par_UUID                    VARCHAR(50),        -- Identificador de la transaccion
    Par_IDUsuario               INT                -- Ultimo usuario en realizar la actualizacion
)
BEGIN
    -- Consulta completa por ID del Producto
    IF(Par_NumOpcion = 1) THEN
        SELECT  IDProducto,         Producto,       Costo,          Precio,     EsGravable
                TipoVentaProd,      EsIEPS,         EsISH,          Estatus,    IDDepartamento,
                CantidadMinima,     CantidadMaxima
            FROM PRODUCTO
            WHERE IDProducto = Par_IDProducto;
    END IF;
END$$