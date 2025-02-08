
-- Crear la base de datos
CREATE DATABASE Escuela;
USE Escuela;

-- Tabla de Estudiantes
CREATE TABLE Estudiantes (
    id_estudiante INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    fecha_nacimiento DATE,
    email VARCHAR(100)
);

-- Tabla de Cursos
CREATE TABLE Cursos (
    id_curso INT AUTO_INCREMENT PRIMARY KEY,
    nombre_curso VARCHAR(100),
    id_profesor INT,
    id_departamento INT,
    FOREIGN KEY (id_profesor) REFERENCES Profesores(id_profesor),
    FOREIGN KEY (id_departamento) REFERENCES Departamentos(id_departamento)
);

-- Tabla de Profesores
CREATE TABLE Profesores (
    id_profesor INT AUTO_INCREMENT PRIMARY KEY,
    nombre_profesor VARCHAR(100),
    email_profesor VARCHAR(100)
);

-- Tabla de Inscripciones (relación muchos a muchos entre estudiantes y cursos)
CREATE TABLE Inscripciones (
    id_inscripcion INT AUTO_INCREMENT PRIMARY KEY,
    id_estudiante INT,
    id_curso INT,
    FOREIGN KEY (id_estudiante) REFERENCES Estudiantes(id_estudiante),
    FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso)
);

-- Tabla de Notas
CREATE TABLE Notas (
    id_nota INT AUTO_INCREMENT PRIMARY KEY,
    id_estudiante INT,
    id_curso INT,
    nota DECIMAL(3, 2),
    FOREIGN KEY (id_estudiante) REFERENCES Estudiantes(id_estudiante),
    FOREIGN KEY (id_curso) REFERENCES Cursos(id_curso)
);

-- Tabla de Departamentos
CREATE TABLE Departamentos (
    id_departamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre_departamento VARCHAR(100)
);





-- Insertar Departamentos
INSERT INTO Departamentos (nombre_departamento) VALUES 
('Matemáticas'), 
('Ciencias'), 
('Historia');

-- Insertar Profesores
INSERT INTO Profesores (nombre_profesor, email_profesor) VALUES 
('Dr. José Pérez', 'joseperez@escuela.com'),
('Lic. María Gómez', 'mariagomez@escuela.com');

-- Insertar Estudiantes
INSERT INTO Estudiantes (nombre, fecha_nacimiento, email) VALUES 
('Juan Rodríguez', '2000-03-01', 'juan@escuela.com'),
('Ana López', '2001-07-15', 'ana@escuela.com');

-- Insertar Cursos
INSERT INTO Cursos (nombre_curso, id_profesor, id_departamento) VALUES 
('Cálculo I', 1, 1),
('Biología', 2, 2),
('Historia Universal', 2, 3);

-- Insertar Inscripciones
INSERT INTO Inscripciones (id_estudiante, id_curso) VALUES 
(1, 1), 
(1, 2),
(2, 3);

-- Insertar Notas
INSERT INTO Notas (id_estudiante, id_curso, nota) VALUES 
(1, 1, 8.5), 
(1, 2, 7.2),
(2, 3, 9.1);











SELECT * FROM estudiantes;
SELECT * FROM departamentos;
SELECT * FROM cursos;
SELECT * FROM inscripciones;
SELECT * FROM notas;
SELECT * FROM profesores;

SELECT *
FROM estudiantes est
INNER JOIN inscripciones ins ON est.id_estudiante = ins.id_estudiante
INNER JOIN cursos cur ON ins.id_curso = cur.id_curso
INNER JOIN profesores prof ON cur.id_profesor = prof.id_profesor
INNER JOIN departamentos dept ON cur.id_departamento = dept.id_departamento
WHERE est.id_estudiante = 1
;


SELECT 
est.nombre,
prof.nombre_profesor As profesor,
dept.nombre_departamento

FROM estudiantes est
INNER JOIN inscripciones ins ON est.id_estudiante = ins.id_estudiante
INNER JOIN cursos cur ON ins.id_curso = cur.id_curso
INNER JOIN profesores prof ON cur.id_profesor = prof.id_profesor
INNER JOIN departamentos dept ON cur.id_departamento = dept.id_departamento
;


-- Transaction, Commit, 

START TRANSACTION;
DELETE FROM departamentos WHERE id_departamento = 9;

SELECT * FROM departamentos;

ROLLBACK;

COMMIT;
