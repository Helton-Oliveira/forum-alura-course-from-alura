CREATE TABLE role(
    id bigint not null AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY(`id`)
);

INSERT INTO role (id, name) VALUES (1, 'LEITURA_ESCRITA');