-- Tabela Categoria
CREATE TABLE categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Tabela Fornecedor
CREATE TABLE fornecedor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Tabela Produto
CREATE TABLE produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    categoria_id BIGINT,
    fornecedor_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id),
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id)
);

-- Tabela Cliente
CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Tabela Carrinho com chave composta
CREATE TABLE carrinho (
    cliente_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    quantidade INT DEFAULT 1,
    PRIMARY KEY (cliente_id, produto_id), -- Chave primária composta
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);


-- Tabela Pedido
CREATE TABLE pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Tabela Pagamento
CREATE TABLE pagamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT,
    valor DECIMAL(10, 2) NOT NULL,
    metodo_pagamento VARCHAR(255) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);

-- Tabela Envio
CREATE TABLE envio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pedido_id BIGINT,
    endereco_entrega VARCHAR(255) NOT NULL,
    status_entrega VARCHAR(255) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);


-- Tabela Auditoria
CREATE TABLE produto_auditoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    produto_id BIGINT,
    valor_antigo DECIMAL(10, 2),
    valor_novo DECIMAL(10, 2),
    data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

-- Trigger de Auditoria
DELIMITER //
CREATE TRIGGER produto_auditoria
AFTER UPDATE ON produto
FOR EACH ROW
BEGIN
    INSERT INTO produto_auditoria (produto_id, valor_antigo, valor_novo, data_alteracao)
    VALUES (OLD.id, OLD.preco, NEW.preco, NOW());
END //
DELIMITER ;

-- Procedure para inserção massiva
DELIMITER //
CREATE PROCEDURE inserir_produtos_massa()
BEGIN
    DECLARE i INT DEFAULT 0;
    WHILE i < 100 DO
        INSERT INTO produto (nome, preco, categoria_id, fornecedor_id)
        VALUES (CONCAT('Produto ', i), ROUND(RAND() * 100, 2),
        (SELECT id FROM categoria ORDER BY RAND() LIMIT 1),
        (SELECT id FROM fornecedor ORDER BY RAND() LIMIT 1));
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;
