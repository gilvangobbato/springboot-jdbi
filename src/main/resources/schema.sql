DROP TABLE IF EXISTS pacientes;

CREATE TABLE pacientes(
    id IDENTITY,
    nome VARCHAR(100) NOT NULL,
    documento VARCHAR(14) DEFAULT NULL,
    last_update TIMESTAMP
);