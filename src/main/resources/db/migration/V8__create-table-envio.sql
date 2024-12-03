CREATE TABLE envio (
    id int AUTO_INCREMENT PRIMARY KEY,
    pedido_id int,
    endereco_entrega VARCHAR(255) NOT NULL,
    status_entrega VARCHAR(255) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);