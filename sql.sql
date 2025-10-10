DROP TABLE tb_livros;
CREATE DATABASE db_biblioteca_progIII;
USE db_biblioteca_progIII;

CREATE TABLE tb_livros(
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(150),
    editora VARCHAR(150),
    ano VARCHAR (10),
    isDisponivel boolean
);

CREATE TABLE tb_usuario(
	id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    login VARCHAR(100),
    senha VARCHAR(100)
);

select * from tb_usuario;