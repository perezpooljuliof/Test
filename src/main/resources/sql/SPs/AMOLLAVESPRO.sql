DELIMITER ;

DROP PROCEDURE IF EXISTS AMOLLAVESPRO;

DELIMITER $$

CREATE PROCEDURE AMOLLAVESPRO (
	-- Stored procedure para generar el siguiente ID de una tabla
	Par_Tabla                   VARCHAR(30),        -- Nombre de la tabla
	INOUT Par_ID                BIGINT(20),         -- Identificador de la tabla

	INOUT Par_NumResultado      INT,                -- Numero de resultado
    INOUT Par_Resultado         VARCHAR(200)        -- Descripcion del resultado
)
BEGIN
    -- Declaracion de variables
    DECLARE Var_ID		    BIGINT(20);

    BODY: BEGIN
        SELECT ID      INTO Var_ID
            FROM    AMOLLAVES
            WHERE   Tabla = Par_Tabla
            FOR UPDATE;


        IF(Var_ID IS NULL)  THEN
            INSERT INTO AMOLLAVES(Tabla, ID) VALUES(Par_Tabla, 1);
            SET     Var_ID := 1;
        ELSE
            SET Var_ID = Var_ID +1;
            UPDATE AMOLLAVES SET ID = Var_ID WHERE Tabla = Par_Tabla;
        END IF;

        SET Par_ID := Var_ID;
        SET Par_NumResultado := 0;
        SET Par_Resultado := 'ID Generado correctamente';
    END BODY;
END$$