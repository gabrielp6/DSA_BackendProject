DROP DATABASE IF EXISTS bbdd;
CREATE DATABASE bbdd;

USE bbdd;


CREATE TABLE Usuario(

	username VARCHAR(30) PRIMARY KEY NOT NULL,
	password VARCHAR(30),
	email VARCHAR(50),
	vida INT,
	fuerza INT,
	coins INT

)ENGINE = InnoDB;


CREATE TABLE compras(

    username VARCHAR(30),
    nameObjeto VARCHAR(30),
    FOREIGN KEY (username) REFERENCES usuario(username),
    FOREIGN KEY (nameObjeto) REFERENCES objeto(name)

)ENGINE = InnoDB;


CREATE TABLE Objeto(
	name VARCHAR(30),
	cost INT,
	idUser VARCHAR,
	healthPointsAdded INT,
	attackedPointsAdded INT

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
