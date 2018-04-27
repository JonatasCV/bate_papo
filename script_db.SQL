CREATE TABLE usuario (
    codUsuario SERIAL       NOT NULL,
    nome       VARCHAR(100) NOT NULL,
    iPaddress   VARCHAR(15),

    CONSTRAINT pk_usuario PRIMARY KEY (codUsuario)
);

CREATE TABLE topico (
    id   SERIAL      NOT NULL,
    nome VARCHAR(30) NOT NULL,

    CONSTRAINT pk_topico PRIMARY KEY (id)
);

CREATE TABLE acesso (
    codUsuario INTEGER   NOT NULL,
    dataHora   TIMESTAMP NOT NULL,

    CONSTRAINT pk_acesso PRIMARY KEY (codUsuario, dataHora),
    CONSTRAINT fk_acesso_usuario FOREIGN KEY (codUsuario) REFERENCES usuario(codUsuario)
);

CREATE TABLE chat (
    codUsuario1 INTEGER   NOT NULL,
    codUsuario2 INTEGER   NOT NULL,
    dataHora    TIMESTAMP NOT NULL,
    topico      INTEGER   NOT NULL,

    CONSTRAINT pk_chat PRIMARY KEY (codUsuario1, codUsuario2, dataHora),
    CONSTRAINT fk_acesso_usuario1 FOREIGN KEY (codUsuario1) REFERENCES usuario(codUsuario),
    CONSTRAINT fk_acesso_usuario2 FOREIGN KEY (codUsuario2) REFERENCES usuario(codUsuario),
    CONSTRAINT fk_chat_topico FOREIGN KEY (topico) REFERENCES topico(id)
);

CREATE TABLE pesquisa (
    dataHora TIMESTAMP NOT NULL,
    topico   INTEGER   NOT NULL,

    CONSTRAINT pk_pesquisa PRIMARY KEY (dataHora, topico),
    CONSTRAINT fk_pesquisa_topico FOREIGN KEY (topico) REFERENCES topico(id)
);

INSERT INTO topico VALUES (1, 'Eleições 2018');
INSERT INTO topico VALUES (2, 'Aposentadoria');
INSERT INTO topico VALUES (3, 'Segurança pública');
INSERT INTO topico VALUES (4, 'Traição');
INSERT INTO topico VALUES (5, 'Preço da gasolina');
INSERT INTO topico VALUES (6, 'Multas de trânsito');
INSERT INTO topico VALUES (7, 'Sistema nacional de saúde');
INSERT INTO topico VALUES (8, 'Educação');