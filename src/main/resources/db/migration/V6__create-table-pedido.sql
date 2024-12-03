CREATE TABLE pedido (
    id int AUTO_INCREMENT PRIMARY KEY,
    cliente_id int,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);
