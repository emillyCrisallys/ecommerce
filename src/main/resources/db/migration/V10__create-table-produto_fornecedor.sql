CREATE TABLE produto_fornecedor (
    id int AUTO_INCREMENT PRIMARY KEY,
    produto_id int NOT NULL,
    fornecedor_id int NOT NULL,
    FOREIGN KEY (produto_id) REFERENCES produto(id),
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id),
    UNIQUE (produto_id, fornecedor_id)
);