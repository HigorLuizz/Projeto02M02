-- Database: clamed

-- DROP DATABASE IF EXISTS clamed;

CREATE DATABASE clamed
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table: public.usuario

-- DROP TABLE IF EXISTS public.usuario;

CREATE TABLE IF NOT EXISTS public.usuario
(
    id integer NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    senha character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuario
    OWNER to postgres;

-- Table: public.medicamento

-- DROP TABLE IF EXISTS public.medicamento;

CREATE TABLE IF NOT EXISTS public.medicamento
(
    id integer NOT NULL DEFAULT nextval('medicamento_id_seq'::regclass),
    nome character varying(25) COLLATE pg_catalog."default" NOT NULL,
    nomelab character varying(25) COLLATE pg_catalog."default" NOT NULL,
    dosagem character varying(10) COLLATE pg_catalog."default" NOT NULL,
    descricao character varying(250) COLLATE pg_catalog."default",
    precounitario character varying(15) COLLATE pg_catalog."default" NOT NULL,
    tipomedicamento character varying(15) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT medicamento_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.medicamento
    OWNER to postgres;

-- Table: public.endereco

-- DROP TABLE IF EXISTS public.endereco;

CREATE TABLE IF NOT EXISTS public.endereco
(
    id integer NOT NULL DEFAULT nextval('endereco_id_seq'::regclass),
    cep character(8) COLLATE pg_catalog."default" NOT NULL,
    logradouro character varying(50) COLLATE pg_catalog."default" NOT NULL,
    complemento character varying(50) COLLATE pg_catalog."default",
    bairro character varying(50) COLLATE pg_catalog."default" NOT NULL,
    localidade character varying(50) COLLATE pg_catalog."default" NOT NULL,
    uf character varying(50) COLLATE pg_catalog."default" NOT NULL,
    numero character varying(15) COLLATE pg_catalog."default" NOT NULL,
    latitude character varying(50) COLLATE pg_catalog."default" NOT NULL,
    longitude character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT endereco_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.endereco
    OWNER to postgres;

-- Table: public.farmacia

-- DROP TABLE IF EXISTS public.farmacia;

CREATE TABLE IF NOT EXISTS public.farmacia
(
    id integer NOT NULL DEFAULT nextval('farmacia_id_seq'::regclass),
    razaosocial character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cnpj character(14) COLLATE pg_catalog."default" NOT NULL,
    nome character varying(50) COLLATE pg_catalog."default" NOT NULL,
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    telefone character varying(20) COLLATE pg_catalog."default",
    celular character varying(20) COLLATE pg_catalog."default" NOT NULL,
    id_endereco integer NOT NULL,
    CONSTRAINT farmacia_pkey PRIMARY KEY (id),
    CONSTRAINT farmacia_id_endereco_fkey FOREIGN KEY (id_endereco)
    REFERENCES public.endereco (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.farmacia
    OWNER to postgres;