-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS EjemploJoins;
USE EjemploJoins;

-- Creación de tablas
CREATE TABLE Clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Pedidos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT,
    producto VARCHAR(100) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Clientes(id)
);



SELECT * FROM clientes;
SELECT * FROM pedidos;

-- Inserción de datos
INSERT INTO Clientes (nombre) VALUES ('Juan'), ('Maria'), ('Pedro');
INSERT INTO Pedidos (cliente_id, producto) VALUES (1, 'Laptop'), (1, 'Mouse'), (2, 'Teclado');

-- INNER JOIN: Solo muestra coincidencias
SELECT Clientes.id, Clientes.nombre, Pedidos.producto 
FROM Clientes
INNER JOIN Pedidos ON Clientes.id = Pedidos.cliente_id;

-- LEFT JOIN: Muestra todos los clientes y sus pedidos si existen
SELECT Clientes.id, Clientes.nombre, Pedidos.producto 
FROM Clientes
LEFT JOIN Pedidos ON Clientes.id = Pedidos.cliente_id;

-- RIGHT JOIN: Muestra todos los pedidos y sus clientes si existen
SELECT Clientes.id, Clientes.nombre, Pedidos.producto 
FROM Clientes
RIGHT JOIN Pedidos ON Clientes.id = Pedidos.cliente_id;

-- FULL OUTER JOIN: Muestra todos los clientes y pedidos, con coincidencias si existen
SELECT Clientes.id, Clientes.nombre, Pedidos.producto 
FROM Clientes
LEFT JOIN Pedidos ON Clientes.id = Pedidos.cliente_id
UNION
SELECT Clientes.id, Clientes.nombre, Pedidos.producto 
FROM Clientes
RIGHT JOIN Pedidos ON Clientes.id = Pedidos.cliente_id;
