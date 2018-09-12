DELIMITER ;

DROP TABLE IF EXISTS AMOLLAVES;

DELIMITER $$

CREATE TABLE AMOLLAVES (
    Tabla               VARCHAR(30)         NOT NULL,
    ID                  BIGINT(20)          NOT NULL
)$$

ALTER TABLE AMOLLAVES ADD INDEX (Tabla)$$
