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

    String username VARCHAR(30),
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
