	CREATE DATABASE ejemplito; -- Así se crea la BD
    
    USE ejemplito; -- Así se indica que se va a usar esa BD
    
		CREATE TABLE usuario(
		usuario_id INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100) NOT NULL,
		email VARCHAR(100) NOT NULL UNIQUE,
		estado ENUM ("activo","inactivo") DEFAULT "activo",
		fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP	
		
		
		
		
		
		
		);
        
        ALTER TABLE usuario
        ADD COLUMN telefono VARCHAR(20) AFTER email;
        