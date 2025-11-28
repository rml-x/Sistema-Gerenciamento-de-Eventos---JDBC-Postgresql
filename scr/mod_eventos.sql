

DROP TABLE IF EXISTS inscricao CASCADE;
DROP TABLE IF EXISTS participante CASCADE;
DROP TABLE IF EXISTS evento CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;

DROP DATABASE IF EXISTS eventosdb;


CREATE DATABASE eventosdb;

\c eventosdb;

CREATE TABLE usuario(
    id_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE evento (
    id_evento SERIAL PRIMARY KEY,
    id_usuario INTEGER NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    data_evento DATE NOT NULL,
    local VARCHAR(200) NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE participante (
    id_participante SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE inscricao ( 
    id_inscricao SERIAL PRIMARY KEY,
    id_participante INTEGER NOT NULL,
    id_evento INTEGER NOT NULL,
    data_inscricao TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (id_participante) REFERENCES participante(id_participante),
    FOREIGN KEY (id_evento) REFERENCES evento(id_evento),
    UNIQUE (id_participante, id_evento)
);


INSERT INTO usuario (nome, email, senha)
VALUES 
('Mariana Silva', 'mariana.silva@email.com', 'senha123'),
('Carlos Andrade', 'carlos.andrade@email.com', 'segura2024'),
('Fernanda Costa', 'fernanda.costa@email.com', 'f3rnanda!@#');

INSERT INTO evento (id_usuario, titulo, descricao, data_evento, local)
VALUES
(1, 'Workshop de Robotica', 'Oficina pratica de montagem de robos com Arduino.', '2025-11-20', 'Laboratorio de Automacao - Bloco C'),
(2, 'Palestra sobre IA', 'Discussao sobre aplicacoes de Inteligencia Artificial na Industria 4.0.', '2025-12-05', 'Auditorio Central'),
(3, 'Feira de Projetos', 'Exposicao dos projetos desenvolvidos pelos alunos do curso tecnico.', '2025-12-10', 'Hall de Entrada - Campus Central');

INSERT INTO participante (nome, email, telefone)
VALUES
('Joao Pereira', 'joao.pereira@email.com', '(53) 99876-1234'),
('Beatriz Lima', 'beatriz.lima@email.com', '(21) 99765-4321'),
('Rafael Gomes', 'rafael.gomes@email.com', '(51) 99654-8765');

INSERT INTO inscricao (id_participante, id_evento)
VALUES
(1, 1), 
(2, 2), 
(3, 3), 
(1, 2), 
(2, 3), 
(3, 1); 

\dt