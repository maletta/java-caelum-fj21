CREATE TABLE public.funcionarios (
	cpf int8 NOT NULL,
	nome varchar(255) NULL,
	sobrenome varchar(255) NULL,
	rg int4 NOT NULL,
	CONSTRAINT funcionarios_pk PRIMARY KEY (cpf, rg)
);