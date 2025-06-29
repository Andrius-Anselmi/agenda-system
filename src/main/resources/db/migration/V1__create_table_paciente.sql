CREATE TABLE paciente (
    id serial PRIMARY KEY ,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR (100) NOT NULL,
    cpf VARCHAR(15) NOT NULL,
    email VARCHAR (100) NOT NULL
);