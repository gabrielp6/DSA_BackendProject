DROP DATABASE IF EXISTS bbdd;
CREATE DATABASE bbdd;

USE bbdd;


CREATE TABLE usuario(
	username VARCHAR(30) NOT NULL,
	password VARCHAR(30),
	email VARCHAR(50),
	coins INT,
	PRIMARY KEY(username)
)ENGINE = InnoDB;

CREATE TABLE objeto(
	nombre VARCHAR(30),
	idObjeto INT,
	coste INT	
)ENGINE = InnoDB;

CREATE TABLE mapa(
	nombre VARCHAR(30),
	enemigos INT
)ENGINE = InnoDB;


CREATE TABLE partida(
   	usuario VARCHAR(30),
	tiempo INT,
	monedasrecogidas INT,
	enemigosmatados INT,
	FOREIGN KEY (usuario) REFERENCES usuario(username)
)ENGINE = InnoDB
