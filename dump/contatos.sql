create table contatos (
        id serial NOT NULL ,
        nome VARCHAR(255),
        email VARCHAR(255),
        endereco VARCHAR(255),
        dataNascimento DATE,
        CONSTRAINT contatos_pk PRIMARY KEY (id)
    );
