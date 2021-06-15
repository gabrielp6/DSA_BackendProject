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
    escudoMadera INT,
    escudoPlata INT,
    escudoOro INT,
    flechaMadera INT,
    flechaPlata INT,
    flechaOro INT,
    manzana INT,
    pocionAzul INT,
    pocionRoja INT

)ENGINE = InnoDB;


CREATE TABLE Objeto(

	nombre VARCHAR(30),
	coste INT,
    descripcion VARCHAR(100),
    avatar VARCHAR(100)

)ENGINE = InnoDB;

INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("escudoOro", 150, "Aumenta 50 puntos tu capacidad de vida", "imagenes/escudoOro.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("escudoPlata", 125, "Aumenta 25 puntos tu capacidad de vida", "imagenes/escudoPlata.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("escudoMadera", 100, "Aumenta 10 puntos tu capacidad de vida", "imagenes/escudoMadera.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("flechaOro", 150, "Aumenta 5 puntos tu capacidad de daño", "imagenes/flechaOro.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("flechaPlata", 125, "Aumenta 3 puntos tu capacidad de daño", "imagenes/flechaPlata.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("flechaMadera", 100, "Aumenta 1 puntos tu capacidad de daño", "imagenes/flechaMadera.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("manzana", 10, "Comida para aumentar 20 puntos tu salud", "imagenes/manzana.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("pocionAzul", 50, "Aumenta tu vida al máximo de la capacidad de tu personaje", "imagenes/pocionAzul.jpeg");
INSERT INTO Objeto (nombre, coste, descripcion, avatar) values ("pocionRoja", 20, "Pone a 100 de vida a tu personaje. ¡Vigila cuando tienes que usarla!", "imagenes/pocionRoja.jpeg");

CREATE TABLE Partida(
   	username VARCHAR(30),
	enemigosMatados INT,
	tiempo INT,
	monedasRecogidas INT,
	puntuacionFinal INT

)ENGINE = InnoDB;

CREATE TABLE RecordUsuario(
   	username VARCHAR(30),
	enemigosMatados INT,
	tiempo INT,
	monedasRecogidas INT,
	puntuacionFinal INT

)ENGINE = InnoDB;
