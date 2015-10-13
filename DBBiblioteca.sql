--DDL

CREATE DATABASE bibliotecaFx;
GO

USE bibliotecaFx;
GO

CREATE TABLE Autor(
	idAutor INT IDENTITY(1,1) NOT NULL,
	Nombre VARCHAR(40) NOT NULL,
	Apellido VARCHAR(20) NOT NULL,
	PRIMARY KEY(idAutor)
);

CREATE TABLE Libro(
	idLibro INT IDENTITY(1,1) NOT NULL,
	ISBN  INT NOT NULL,
	Nombre VARCHAR(255) NOT NULL, 
	idAutor INT NOT NULL,
	Editorial VARCHAR(255) NOT NULL,
	Genero VARCHAR(255) NOT NULL,
	Precio INT NOT NULL,
	PRIMARY KEY(idLibro),
	FOREIGN KEY (idAutor) REFERENCES Autor(idAutor) ON DELETE CASCADE
);


CREATE TABLE Usuario(
	idUsuario INT IDENTITY (1,1),
	Nombre VARCHAR(255) NOT NULL,
	Apellido VARCHAR(255) NOT NULL,
	PRIMARY KEY(idUsuario)
);

CREATE TABLE Alumno(
	idAlumno INT IDENTITY (1,1),
	idUsuario INT NOT NULL,
	Nombre VARCHAR(255) NOT NULL,
	Apellido VARCHAR(255) NOT NULL,
	Carnet INT NOT NULL,	
	PRIMARY KEY(idAlumno),
	FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario) ON DELETE CASCADE
);

CREATE TABLE Biblotecario(
	idBiblotecario INT IDENTITY (1,1),
	Nombre VARCHAR (255),
	Apellido VARCHAR (255),
	Contrasena VARCHAR (30),
	PRIMARY KEY(idBiblotecario)
);

CREATE TABLE Prestamo(
	idPrestamo INT IDENTITY (1,1),
	idLibro INT NOT NULL,
	idBiblotecario INT NOT NULL,
	idAlumno INT NOT NULL,
	fechaPrestamo DATETIME NOT NULL,
	fechaEntrega DATETIME NOT NULL,
	FOREIGN KEY (idLibro ) REFERENCES Libro(idLibro) ON DELETE CASCADE,
	FOREIGN KEY (idBiblotecario) REFERENCES Biblotecario(idBiblotecario) ON DELETE CASCADE,
	FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno) ON DELETE CASCADE,
	PRIMARY KEY(idPrestamo)
);


CREATE TABLE Bitacora(
	idBitacora iNT IDENTITY (1,1),
	Evento VARCHAR (255),
	fechaHora DATETIME NOT NULL,
	Usuario VARCHAR (255)
	PRIMARY KEY (idBitacora)
);

INSERT INTO Autor(Nombre, Apellido)
	VALUES('JR', 'Tolkein');

INSERT INTO Autor(Nombre, Apellido)
	VALUES('Gabriel', 'Garcia');

INSERT INTO Autor(Nombre, Apellido)
	VALUES('Oscar', 'Wilde');

INSERT INTO Autor(Nombre, Apellido)
	VALUES('Dan', 'Brown');

INSERT INTO Autor(Nombre, Apellido)
	VALUES('Homero', '');   
	
INSERT INTO Autor(Nombre, Apellido)
	VALUES('Alejandro', 'Dumas');
	
INSERT INTO Autor(Nombre, Apellido)
	VALUES('Isabelle', 'Allende');
	
INSERT INTO Autor(Nombre, Apellido)
	VALUES('Dante', 'Alligheri');
	
INSERT INTO Autor(Nombre, Apellido)
	VALUES('Franz', 'Kafka');	

INSERT INTO Autor(Nombre, Apellido)
	VALUES('Carlos', 'Ruiz');					

 SELECT * FROM Autor;
---------------------------------------------
INSERT INTO Libro(ISBN, Nombre, idAutor, Editorial, Genero, Precio)
	VALUES(1423456, 'Azul', 1, 'Larouse', 'Narrativo', 28);

INSERT INTO Libro(ISBN, Nombre, idAutor, Editorial, Genero, Precio)
	VALUES(3890928, 'Los Nazarenos', 2, 'Piedra Santa', 'Narrativo', 45);

INSERT INTO Libro(ISBN, Nombre, idAutor, Editorial, Genero, Precio)
	VALUES(4909987, 'Abraham Lincoln', 3, 'Santillana', 'Narrativo', 28);

INSERT INTO Libro(ISBN, Nombre, idAutor, Editorial, Genero, Precio)
	VALUES(8932112, 'Bajo la misma estrella', 4, 'Ginson', 'Narrativo', 150);

INSERT INTO Libro(ISBN, Nombre, idAutor, Editorial, Genero, Precio)
	VALUES(3902909, 'Cien años de soledad', 5, 'Santillana', 'Narrativo', 190);

INSERT INTO Libro(ISBN, Nombre, idAutor, Editorial, Genero, Precio)
	VALUES(3789838, 'Harry Potter', 6, 'Ever', 'Narrativo', 800);

INSERT INTO Libro(ISBN, Nombre, idAutor, Editorial, Genero, Precio)
	VALUES(6654437, 'Don Quijote de la mancha', 7, 'Casa Salvadoreña', 'Narrativo', 100);

INSERT INTO Libro(ISBN, Nombre, idAutor, Editorial, Genero, Precio)
	VALUES(7634321, 'El diario de Anne Frank', 8, 'Arredondo', 'Narrativo', 80);

INSERT INTO Libro(ISBN, Nombre, idAutor, Editorial, Genero, Precio)
	VALUES(7827637, 'El alquimista', 9, 'Casa Salvadoreña', 'Narrativo', 239);

INSERT INTO Libro(ISBN, Nombre, idAutor, Editorial, Genero, Precio)
	VALUES(78382983, 'El perfume', 10, 'Larouse', 'Narrativo', 198);

SELECT * FROM Libro;
---------------------------------------------

INSERT INTO Usuario(Nombre, Apellido)
	VALUES('Luisa', 'Marroquin');

INSERT INTO Usuario(Nombre, Apellido)
	VALUES('Edison', 'Tubac');

INSERT INTO Usuario(Nombre, Apellido)
	VALUES('Fernanda', 'Marmol');

INSERT INTO Usuario(Nombre, Apellido)
	VALUES('Luis', 'Aguilar');

INSERT INTO Usuario(Nombre, Apellido)
	VALUES('Sofia', 'Martinez');   
	
INSERT INTO Usuario(Nombre, Apellido)
	VALUES('Carlos', 'Sandoval');
	
INSERT INTO Usuario(Nombre, Apellido)
	VALUES('Alejandra', 'Veteta');
	
INSERT INTO Usuario(Nombre, Apellido)
	VALUES('Luisa', 'Zapata');
	
INSERT INTO Usuario(Nombre, Apellido)
	VALUES('Jorge', 'Godinez');	

INSERT INTO Usuario(Nombre, Apellido)
	VALUES('Edwin', 'Lorenzana');					

 SELECT * FROM Usuario;
------------------------------------------------

INSERT INTO Alumno(idUsuario, Nombre, Apellido, Carnet)
	VALUES(1, 'Luisa', 'Marroquin', 2011178);

INSERT INTO Alumno(idUsuario, Nombre, Apellido, Carnet)
	VALUES(2, 'Edison', 'Tubac', 2014657);

INSERT INTO Alumno(idUsuario, Nombre, Apellido, Carnet)
	VALUES(3, 'Fernanda', 'Marmol', 2011123);

INSERT INTO Alumno(idUsuario, Nombre, Apellido, Carnet)
	VALUES(4, 'Luis', 'Aguilar', 2014652);

INSERT INTO Alumno(idUsuario, Nombre, Apellido, Carnet)
	VALUES(5, 'Sofia', 'Martinez', 2013456);   
	
INSERT INTO Alumno(idUsuario, Nombre, Apellido, Carnet)
	VALUES(6, 'Carlos', 'Sandoval', 2015678);
	
INSERT INTO Alumno(idUsuario, Nombre, Apellido, Carnet)
	VALUES(7, 'Alejandra', 'Veteta', 2012389);
	
INSERT INTO Alumno(idUsuario, Nombre, Apellido, Carnet)
	VALUES(8, 'Luisa', 'Zapata', 2010782);
	
INSERT INTO Alumno(idUsuario, Nombre, Apellido, Carnet)
	VALUES(9, 'Jorge', 'Godinez', 2014999);	

INSERT INTO Alumno(idUsuario, Nombre, Apellido, Carnet)
	VALUES(10, 'Edwin', 'Lorenzana', 2011158);					

 SELECT * FROM Alumno;

 --------------------------------------------------------

 INSERT INTO Biblotecario(Nombre, Apellido, Contrasena)
	VALUES('Mario', 'Santiago', 123);

 INSERT INTO Biblotecario(Nombre, Apellido, Contrasena)
	VALUES('Pedro', 'Rodriguez', 234);

 INSERT INTO Biblotecario(Nombre, Apellido, Contrasena)
	VALUES('Gustavo', 'Cepeda', 345);

 INSERT INTO Biblotecario(Nombre, Apellido, Contrasena)
	VALUES('Enrique', 'Padilla', 456);

 INSERT INTO Biblotecario(Nombre, Apellido, Contrasena)
	VALUES('Rodrigo', 'Sipaque', 567);   
	
 INSERT INTO Biblotecario(Nombre, Apellido, Contrasena)
	VALUES('Wilmer', 'Omar', 678);
	
 INSERT INTO Biblotecario(Nombre, Apellido, Contrasena)
	VALUES('Crisitna', 'Aguilar', 789);
	
 INSERT INTO Biblotecario(Nombre, Apellido, Contrasena)
	VALUES('Marvin', 'Matias', 890);
	
 INSERT INTO Biblotecario(Nombre, Apellido, Contrasena)
	VALUES('Manuel', 'Herrera', 978);	

 INSERT INTO Biblotecario(Nombre, Apellido, Contrasena)
	VALUES('Gerber', 'Alvarado', 876);					

 SELECT * FROM Biblotecario;


 ---------------------------------------------------------

 INSERT INTO Prestamo(idLibro, idBiblotecario, idAlumno, fechaPrestamo, fechaEntrega)
	VALUES(1, 1, 1, 2015-1-1, 2015-2-1);

 INSERT INTO Prestamo(idLibro, idBiblotecario, idAlumno, fechaPrestamo, fechaEntrega)
	VALUES(2, 2, 2, 2015-1-12, 2015-1-28);

 INSERT INTO Prestamo(idLibro, idBiblotecario, idAlumno, fechaPrestamo, fechaEntrega)
	VALUES(3, 3, 3, 2015-2-11, 2015-3-4);

 INSERT INTO Prestamo(idLibro, idBiblotecario, idAlumno, fechaPrestamo, fechaEntrega)
	VALUES(4, 4, 4, 2015-3-12, 2015-4-6);

 INSERT INTO Prestamo(idLibro, idBiblotecario, idAlumno, fechaPrestamo, fechaEntrega)
	VALUES(5, 5, 5, 2015-2-2, 2015-2-29); 
	
 INSERT INTO Prestamo(idLibro, idBiblotecario, idAlumno, fechaPrestamo, fechaEntrega)
	VALUES(6, 6, 6, 2015-5-23, 2015-5-27);
	
 INSERT INTO Prestamo(idLibro, idBiblotecario, idAlumno, fechaPrestamo, fechaEntrega)
	VALUES(7, 7, 7, 2015-4-4, 2015-4-22);
	
 INSERT INTO Prestamo(idLibro, idBiblotecario, idAlumno, fechaPrestamo, fechaEntrega)
	VALUES(8, 8, 8, 2015-5-15, 2015-5-25);
	
 INSERT INTO Prestamo(idLibro, idBiblotecario, idAlumno, fechaPrestamo, fechaEntrega)
	VALUES(9, 9, 9, 2015-6-1, 2015-6-2);	

 INSERT INTO Prestamo(idLibro, idBiblotecario, idAlumno, fechaPrestamo, fechaEntrega)
	VALUES(10, 10, 10, 2015-5-23, 2015-6-10);				

 SELECT * FROM Prestamo;