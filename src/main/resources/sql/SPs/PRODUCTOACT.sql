DELIMITER ;

DROP PROCEDURE IF EXISTS PRODUCTOACT;

DELIMITER $$

CREATE PROCEDURE PRODUCTOACT (
	-- Stored procedure para dar actualizar la informacion de un producto
	Par_IDProducto              INT,                -- Identificador del producto
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

    Par_UUID                    VARCHAR(50),        -- Identificador de la transaccion
    Par_IDUsuario               INT,                -- Ultimo usuario en realizar la actualizacion

    Par_NumOpcion               INT,                -- Numero de Opcion
    Par_MostrarResultado        CHAR(1),            -- Opcion para habilitar salida de resultado en pantalla
    INOUT Par_NumResultado      INT,                -- Numero de resultado
    INOUT Par_Resultado         VARCHAR(200)        -- Descripcion del resultado
)
BEGIN
    -- Declaracion de variables
    DECLARE Var_IDProducto      INT;

    -- Asignacion de valores por defecto
    SET Par_Producto 		    := IFNULL(Par_Producto, '');
    SET Par_Costo 				:= IFNULL(Par_Costo, 0.0);
    SET Par_Precio 				:= IFNULL(Par_Precio, 0.0);
    SET Par_Codigo              := IFNULL(Par_Codigo, '');
    SET Par_TipoVentaProd       := IFNULL(Par_TipoVentaProd, '');
    SET Par_EsGravable          := IFNULL(Par_EsGravable, 'N');
    SET Par_EsIEPS              := IFNULL(Par_EsIEPS, 'N');
    SET Par_EsISH               := IFNULL(Par_EsISH, 'N');
    SET Par_IDDepartamento      := IFNULL(Par_IDDepartamento, 0);
    SET Par_CantidadMinima 	    := IFNULL(Par_CantidadMinima, 0.0);
    SET Par_CantidadMaxima 		:= IFNULL(Par_CantidadMaxima, 0.0);

    SET Par_UUID                := IFNULL(Par_UUID, '');
    SET Par_IDUsuario 		    := IFNULL(Par_IDUsuario, 0);

    BODY: BEGIN
        -- Actualizacion completa del producto
        IF(Par_NumOpcion = 1) THEN
            IF(Par_Producto = '') THEN
                SET Par_Resultado := 'Especifique el nombre del producto';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;

            IF(Par_Costo <= 0.0) THEN
                SET Par_Resultado := 'Especifique el costo del producto';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;

            IF(Par_Precio <= 0.0) THEN
                SET Par_Resultado := 'Especifique el precio del producto';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;

            IF(Par_TipoVentaProd NOT IN ('U', 'G')) THEN
                SET Par_Resultado := 'Especifique el tipo de venta del producto (U = Unidad, G = Granel)';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;

            IF(Par_EsGravable NOT IN ('S', 'N')) THEN
                SET Par_Resultado := 'Especifique si el producto es Gravable (S = SI, N = NO)';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;

            IF(Par_EsIEPS NOT IN ('S', 'N')) THEN
                SET Par_Resultado := 'Especifique si el producto genera IEPS (S = SI, N = NO)';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;

            IF(Par_EsISH NOT IN ('S', 'N')) THEN
                SET Par_Resultado := 'Especifique si el producto genera ISH (S = SI, N = NO)';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;

            IF(Par_CantidadMinima < 0) THEN
                SET Par_Resultado := 'Especifique una cantidad minima valida';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;

            IF(Par_CantidadMaxima < 0) THEN
                SET Par_Resultado := 'Especifique una cantidad maxima valida';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;

            -- Verificamos que el producto que se intenta modificar realmente existe
            SELECT IDProducto INTO Var_IDProducto
                FROM PRODUCTO
                WHERE IDProducto = Par_IDProducto;

            IF(Var_IDProducto IS NULL) THEN
                SET Par_Resultado := 'El producto que se intenta modificar no existe.';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;

            UPDATE PRODUCTO
                SET     Producto        = Par_Producto,
                        Costo           = Par_Costo,
                        Precio          = Par_Precio,
                        TipoVentaProd   = Par_TipoVentaProd,
                        EsIEPS          = Par_EsIEPS,
                        EsISH           = Par_EsISH,
                        EsGravable      = Par_EsGravable,
                        IDDepartamento  = Par_IDDepartamento,
                        UUID            = UUID,
                        IDUsuario       = Par_IDUsuario,
                        FechaAct        = NOW()
                WHERE IDProducto = Par_IDProducto;

            SET Par_Resultado := 'Producto actualizado correctamente.';
            SET Par_NumResultado := 0;
            SET Par_IDProducto := Par_IDProducto;
            LEAVE BODY;
        END IF;

        -- Baja del Producto
        IF(Par_NumOpcion = 2) THEN
            -- Verificamos que el producto que se intenta modificar realmente existe
            SELECT IDProducto INTO Var_IDProducto
                FROM PRODUCTO
                WHERE IDProducto = Par_IDProducto;

            IF(Var_IDProducto IS NULL) THEN
                SET Par_Resultado := 'El producto que se intenta modificar no existe.';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;

            UPDATE PRODUCTO
                SET     Estatus         = 'B',
                        UUID            = UUID,
                        IDUsuario       = Par_IDUsuario,
                        FechaAct        = NOW()
                WHERE IDProducto = Par_IDProducto;

            SET Par_Resultado := 'Producto dado de baja correctamente.';
            SET Par_NumResultado := 0;
            SET Par_IDProducto := Par_IDProducto;
            LEAVE BODY;
        END IF;
    END BODY;

    IF(Par_MostrarResultado = 'S') THEN
        SELECT Par_NumResultado, Par_Resultado, Par_IDProducto;
    END IF;
END$$