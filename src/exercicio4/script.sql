create database usuario;
use usuario;

CREATE TABLE IF NOT EXISTS nivel(
	id int not null primary key auto_increment,
	descricao varchar(50) not null
);

CREATE TABLE IF NOT EXISTS usuario(
	id int not null primary key auto_increment,
	nome varchar(45) not null,
	email varchar(45) not null,
    senha varchar(45) not null,
	
    nivel int not null,
    FOREIGN KEY(nivel) REFERENCES nivel(id)
);

insert into nivel(id, descricao) values (1, 'Admin');
insert into nivel(id, descricao) values (2, 'Normal');
