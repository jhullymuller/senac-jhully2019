create database empresa;
use empresa;

CREATE TABLE IF NOT EXISTS usuario(
	id int not null primary key auto_increment,
	nome varchar(45) not null,
	datanascimento date not null,
     cep varchar (45) not null
);
CREATE TABLE IF NOT EXISTS produto(
	id int not null primary key auto_increment,
    nomeproduto varchar(50) not null,
    valor double not null,
    quantidade int not null
    );


