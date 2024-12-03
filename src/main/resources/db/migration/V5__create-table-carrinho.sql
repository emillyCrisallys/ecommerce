CREATE TABLE carrinho (
    cliente_id int NOT NULL,
    produto_id int NOT NULL,
    quantidade INT DEFAULT 1,
    PRIMARY KEY (cliente_id, produto_id), -- Chave primária composta
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);