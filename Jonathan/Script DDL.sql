CREATE DATABASE ejemplito; -- Asi se crea la BD

USE ejemplito; -- Asi se le indica que se va a usar esa BD

CREATE TABLE usuario(
usuario_id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
estado ENUM('activo', 'inactivo's) DEFAULT 'activo',
fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE usuario
ADD COLUMN telefono VARCHAR(20) AFTER email;

ALTER TABLE usuario
MODIFY COLUMN nombre VARCHAR(200) NOT NULL;

ALTER TABLE usuario
DROP COLUMN telefono;

DROP TABLE IF EXISTS usuario;

DROP DATABASE IF EXISTS ejemplito;

TRUNCATE TABLE usuario;