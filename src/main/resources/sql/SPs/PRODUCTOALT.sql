DELIMITER ;

DROP PROCEDURE IF EXISTS PRODUCTOALT;

DELIMITER $$

CREATE PROCEDURE PRODUCTOALT (
	-- Stored procedure para dar de alta un producto
	INOUT Par_IDProducto        INT,                -- Identificador del producto
    Par_Producto                VARCHAR(100),       -- Nombre del Producto
    Par_Costo                   DECIMAL(10,2),      -- Costo
    Par_Precio                  DECIMAL(10,2),      -- Precio
    Par_esGravable              CHAR(1),            -- Es Gravable
    Par_TipoVentaProd           CHAR(1),            -- Tipo de Venta del producto
    Par_esIEPS                  CHAR(1),            -- Es IEPS
    Par_esISH                   CHAR(1),            -- Es ISH

    Par_UUID                    VARCHAR(50),        -- Identificador de la transaccion
    Par_IDUsuario               INT,                -- Ultimo usuario en realizar la actualizacion

    INOUT Par_NumResultado      INT,                -- Numero de resultado
    INOUT Par_Resultado         VARCHAR(200),       -- Descripcion del resultado
)
BEGIN
    -- Declaracion de variables

    -- Asignacion de valores por defecto
    SET Par_Producto 		    := IFNULL(Par_Producto, '');
    SET Par_Precio 				:= IFNULL(Par_Precio, 0.0);
    SET Par_Costo 				:= IFNULL(Par_Costo, 0.0);
    SET Par_esGravable          := IFNULL(Par_esGravable, '');
    SET Par_TipoVentaProd       := IFNULL(Par_TipoVentaProd, '');
    SET Par_esIEPS              := IFNULL(Par_esIEPS, '');
    SET Par_esISH               := IFNULL(Par_esISH, '');

    BODY: BEGIN



    END BODY;
END$$