DROP DATABASE IF EXISTS bbdd;
CREATE DATABASE bbdd;

USE bbdd;


CREATE TABLE Usuario(

	id VARCHAR(30) PRIMARY KEY NOT NULL,
	username VARCHAR(30),
	password VARCHAR(30),
	email VARCHAR(50),
	vida INT,
	defense INT,
	coins INT,

)ENGINE = InnoDB;

CREATE TABLE Objeto(
	name VARCHAR(30),
	cost INT,
	idObject INT,
	idUser VARCHAR,
	healthPointsAdded INT,
	defensePointsAdded INT

)ENGINE = InnoDB;

CREATE TABLE Mapa(
	nameMap VARCHAR(30),
	idMap VARCHAR
)ENGINE = InnoDB;


CREATE TABLE Partida(
   	usuario VARCHAR(30),
	tiempo INT,
	monedasrecogidas INT,
	enemigosmatados INT,
	FOREIGN KEY (usuario) REFERENCES usuario(username)
)ENGINE = InnoDB
