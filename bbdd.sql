DROP DATABASE IF EXISTS bbdd;
CREATE DATABASE bbdd;

USE bbdd;


CREATE TABLE Usuario(

    ID VARCHAR(30),
	username VARCHAR(30) PRIMARY KEY NOT NULL,
	password VARCHAR(30),
	email VARCHAR(50),
	vida INT,
	fuerza INT,
	coins INT

)ENGINE = InnoDB;


CREATE TABLE Inventario(

    username VARCHAR(30),
    escudoMaderaComprado INT,
    escudoPlataComprado INT,
    escudoOroComprado INT,
    flechaMaderaComprada INT,
    flechaPlataComprada INT,
    flechaOroComprada INT,
    manzanaComprada INT,
    pocionAzulComprada INT,
    pocionRojaComprada INT

)ENGINE = InnoDB;


CREATE TABLE Objeto(

	nombre VARCHAR(30),
	coste INT,
    descripcion VARCHAR(100),
    avatar VARCHAR(100)

)ENGINE = InnoDB;

INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("escudoOro", 150, "Aumenta 50 puntos tu capacidad de vida", "public/imagenes/escudoOro.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("escudoPlata", 125, "Aumenta 25 puntos tu capacidad de vida", "public/imagenes/escudoPlata.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("escudoMadera", 100, "Aumenta 10 puntos tu capacidad de vida", "public/imagenes/escudoMadera.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("flechaOro", 150, "Aumenta 5 puntos tu capacidad de daño", "public/imagenes/flechaOro.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("flechaPlata", 125, "Aumenta 3 puntos tu capacidad de daño", "public/imagenes/flechaPlata.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("flechaMadera", 100, "Aumenta 1 puntos tu capacidad de daño", "public/imagenes/flechaMadera.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("manzana", 10, "Comida para aumentar 20 puntos tu salud", "public/imagenes/manzana.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("pocionAzul", 50, "Aumenta tu vida al máximo de la capacidad de tu personaje", "public/imagenes/pocionAzul.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("pocionRoja", 20, "Pone a 100 de vida a tu personaje. ¡Vigila cuando tienes que usarla!", "public/imagenes/pocionRoja.jpeg");


CREATE TABLE Mapa(

	nameMap VARCHAR(30)
)ENGINE = InnoDB;


CREATE TABLE Partida(
   	usuario VARCHAR(30),
	tiempo INT,
	monedasrecogidas INT,
	enemigosmatados INT,
	FOREIGN KEY (usuario) REFERENCES usuario(username)
)ENGINE = InnoDB
