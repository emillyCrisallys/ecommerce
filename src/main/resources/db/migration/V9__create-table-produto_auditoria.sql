CREATE TABLE produto_auditoria (
    id int AUTO_INCREMENT PRIMARY KEY,
    produto_id int,
    valor_antigo DECIMAL(10, 2),
    valor_novo DECIMAL(10, 2),
    data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);