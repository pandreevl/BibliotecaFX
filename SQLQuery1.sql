CREATE DATABASE BibliotecaFx
GO 
USE BibliotecaFx
GO
CREATE TABLE Usuario
(
 codigoUsuario INT IDENTITY (1,1) NOT NULL PRIMARY KEY,
 nombre VARCHAR(50) NOT NULL,
 telefono INT NOT NULL,
 direccion VARCHAR(50) NOT NULL
 )
 GO 
CREATE TABLE Autor 
(
 codigoAutor INT IDENTITY (1,1) NOT NULL PRIMARY KEY, 
 nombre VARCHAR (50) NOT NULL,
)
GO
CREATE TABLE Libro
(
codigoLibro  INT IDENTITY (1,1) NOT NULL PRIMARY KEY,
titulo VARCHAR (50) NOT NULL,
editorial VARCHAR (50) NOT NULL,
paginas INT NOT NULL,
ISBN INT UNIQUE
)
GO
CREATE TABLE Ejemplar
(
codigoEjemplar INT IDENTITY (1,1) NOT NULL PRIMARY KEY,
localizacion VARCHAR(50) NOT NULL,
codigoLibro INT FOREIGN KEY REFERENCES Libro(codigoLibro)
)
GO

CREATE TABLE Prestamo
(
codigoPrestamo INT IDENTITY (1,1) NOT NULL PRIMARY KEY,
fechaPrestamo DATE NOT NULL,
fechaDevolucion DATE NOT NULL
)
GO

CREATE TABLE Escribe
(
codigoAutor INT FOREIGN KEY REFERENCES Autor(codigoAutor),
codigoLibro INT FOREIGN KEY REFERENCES Libro(codigoLibro), 
)
GO

INSERT INTO Autor(nombre) VALUES ('GABRIEL GARCÍA MÁRQUEZ')
INSERT INTO Autor(nombre) VALUES ('PABLO NERUDA')
INSERT INTO Autor(nombre) VALUES ('CARLOS FUENTES')
INSERT INTO Autor(nombre) VALUES ('JULIO CORTÁZAR')
INSERT INTO Autor(nombre) VALUES ('MARIO VARGAS LLOSA')
INSERT INTO Autor(nombre) VALUES ('JAIME SABINES')
INSERT INTO Autor(nombre) VALUES ('JORGE LUIS BORGES')
INSERT INTO Autor(nombre) VALUES ('CÉSAR VALLEJO')
INSERT INTO Autor(nombre) VALUES (' ALEJO CARPENTIER')
INSERT INTO Autor(nombre) VALUES ('VICENTE HUIDOBRO')

INSERT INTO Usuario(nombre,telefono,direccion) VALUES ('JUAN','123456','GUATEMALA')
INSERT INTO Usuario(nombre,telefono,direccion) VALUES ('PEDOR','988765','GUATEMALA')
INSERT INTO Usuario(nombre,telefono,direccion) VALUES ('ADRIAN','4322127','SAN MARCOS')
INSERT INTO Usuario(nombre,telefono,direccion) VALUES ('MARIANO','456789','JUTIAPA')
INSERT INTO Usuario(nombre,telefono,direccion) VALUES ('ERICK','54324','SALVADOR')
INSERT INTO Usuario(nombre,telefono,direccion) VALUES ('OMAR','2432','GUATEMALA')
INSERT INTO Usuario(nombre,telefono,direccion) VALUES ('MARCOS','12314','ZACAPA')
INSERT INTO Usuario(nombre,telefono,direccion) VALUES ('ANDREE','671238','GUATEMALA')
INSERT INTO Usuario(nombre,telefono,direccion) VALUES ('AXEL','234234','PETEN')
INSERT INTO Usuario(nombre,telefono,direccion) VALUES ('DAVID','45241','GUATEMALA')

INSERT INTO Libro(codigoLibro,titulo,editorial,paginas,ISBN) VALUES('1','Cien años de soledad','','1234','7658765',)
INSERT INTO Libro(codigoLibro,titulo,editorial,paginas,ISBN) VALUES('2','Harry Potter','','100','765432876',)
INSERT INTO Libro(codigoLibro,titulo,editorial,paginas,ISBN) VALUES('3','El principito','','200','098765',)
INSERT INTO Libro(codigoLibro,titulo,editorial,paginas,ISBN) VALUES('4','Don Quijote de la Mancha','','300','13561234',)
INSERT INTO Libro(codigoLibro,titulo,editorial,paginas,ISBN) VALUES('5','El diario de Ana Frank','','500','765432',)
INSERT INTO Libro(codigoLibro,titulo,editorial,paginas,ISBN) VALUES('6',' El alquimista','','400','09876',)
INSERT INTO Libro(codigoLibro,titulo,editorial,paginas,ISBN) VALUES('7','El código Da Vinc','','600','13456',)
INSERT INTO Libro(codigoLibro,titulo,editorial,paginas,ISBN) VALUES('8',' El Perfume','','120','9876543',)
INSERT INTO Libro(codigoLibro,titulo,editorial,paginas,ISBN) VALUES('9','El señor de los anillos','','3214','35780987533',)
INSERT INTO Libro(codigoLibro,titulo,editorial,paginas,ISBN) VALUES('10','El amor en los tiempos del cólera','','7654','0876543213',)
