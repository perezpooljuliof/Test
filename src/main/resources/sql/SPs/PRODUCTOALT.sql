DELIMITER ;

DROP PROCEDURE IF EXISTS PRODUCTOALT;

DELIMITER $$

CREATE PROCEDURE PRODUCTOALT (
	-- Stored procedure para dar de alta un producto
	INOUT Par_IDProducto        INT,                -- Identificador del producto
    Par_Producto                VARCHAR(100),       -- Nombre del Producto
    Par_Costo                   DECIMAL(10,2),      -- Costo
    Par_Precio                  DECIMAL(10,2),      -- Precio
    Par_CodigoRapido            VARCHAR(10),        -- Codigo de Barras

    Par_CodigoBarras            VARCHAR(40),        -- Codigo de Barras
    Par_TipoVentaProd           CHAR(1),            -- Tipo de Venta del producto (U = Unidad/Pza, G = Granel)
    Par_EsGravable              CHAR(1),            -- Es Gravable
    Par_EsIEPS                  CHAR(1),            -- Es IEPS
    Par_EsISH                   CHAR(1),            -- Es ISH

    Par_Estatus                 CHAR(1),            -- Estatus del producto (Alta por defecto)
    Par_IDDepartamento          INT,                -- ID del Departamento
    Par_CantidadMinima          DECIMAL(6,2),       -- Cantidad minima
    Par_CantidadMaxima          DECIMAL(6,2),       -- Cantidad maxima

    Par_MostrarResultado        CHAR(1),            -- Opcion para habilitar salida de resultado en pantalla
    INOUT Par_NumResultado      INT,                -- Numero de resultado
    INOUT Par_Resultado         VARCHAR(200),        -- Descripcion del resultado

    Par_UUID                    BIGINT(20),        -- Identificador de la transaccion
    Par_IDUsuario               INT,                -- Ultimo usuario en realizar la actualizacion
    Par_Programa                VARCHAR(70)         -- URL o programa que realiza la ultima actualizacion
)
BEGIN
    -- Declaracion de variables
    DECLARE Var_IDProducto      INT;
    DECLARE Var_IDProductoIgual INT;

    -- Asignacion de valores por defecto
    SET Par_Producto 		    := IFNULL(Par_Producto, '');
    SET Par_Costo 				:= IFNULL(Par_Costo, 0.0);
    SET Par_Precio 				:= IFNULL(Par_Precio, 0.0);
    SET Par_CodigoRapido        := IFNULL(Par_CodigoRapido, '');
    SET Par_CodigoBarras        := IFNULL(Par_CodigoBarras, '');
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

        IF(Par_CodigoBarras = '') THEN
            SET Par_Resultado := 'Especifique el codigo de barras del producto';
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

        SELECT IDProducto INTO Var_IDProductoIgual
            FROM PRODUCTO
            WHERE Producto = Par_Producto;

        IF(Var_IDProductoIgual IS NOT NULL) THEN
            SET Par_Resultado := 'Existe un producto con el mismo nombre, especifique un nombre diferente.';
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

        SELECT IDProducto INTO Var_IDProductoIgual
            FROM PRODUCTO
            WHERE CodigoBarras = Par_CodigoBarras
            LIMIT 1;

        IF(Var_IDProductoIgual IS NOT NULL) THEN
            SET Par_Resultado := 'Existe un producto con el mismo codigo de barras, especifique un codigo diferente.';
            SET Par_NumResultado := 1;
            LEAVE BODY;
        END IF;

        IF(Par_CodigoRapido <> '') THEN
            SELECT IDProducto INTO Var_IDProductoIgual
                FROM PRODUCTO
                WHERE CodigoRapido = Par_CodigoRapido
                LIMIT 1;

            IF(Var_IDProductoIgual IS NOT NULL) THEN
                SET Par_Resultado := 'Existe un producto con el mismo codigo rapido, especifique un codigo diferente.';
                SET Par_NumResultado := 1;
                LEAVE BODY;
            END IF;
        END IF;


        CALL AMOLLAVESPRO ('PRODUCTO', Var_IDProducto, Par_NumResultado, Par_Resultado);

        IF(Par_NumResultado > 0) THEN
            LEAVE BODY;
        END IF;

        INSERT INTO PRODUCTO(
                IDProducto,         Producto,           Costo,              Precio,             TipoVentaProd,
                EsIEPS,             EsISH,              EsGravable,         Estatus,            IDDepartamento,
                CodigoRapido,       CodigoBarras,       CantidadMinima,     Cantidadmaxima,     UUID,
                FechaAct,           IDUsuario,          Programa
            )
            VALUES(
                Var_IDProducto,     Par_Producto,       Par_Costo,          Par_Precio,         Par_TipoVentaProd,
                Par_EsIEPS,         Par_EsISH,          Par_EsGravable,     'A',                Par_IDDepartamento,
                Par_CodigoRapido,   Par_CodigoBarras,   Par_CantidadMinima, Par_CantidadMaxima, Par_UUID,
                NOW(),              Par_IDUsuario,      Par_Programa
            );

        SET Par_Resultado := 'Producto registrado correctamente.';
        SET Par_NumResultado := 0;
        SET Par_IDProducto := Var_IDProducto;
    END BODY;

    IF(Par_MostrarResultado = 'S') THEN
        SELECT Par_NumResultado NumResultado, Par_Resultado Resultado, Par_IDProducto IDProducto;
    END IF;
END$$