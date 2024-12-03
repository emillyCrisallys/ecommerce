CREATE TABLE pagamento (
    id int AUTO_INCREMENT PRIMARY KEY,
    pedido_id int,
    valor DECIMAL(10, 2) NOT NULL,
    metodo_pagamento VARCHAR(255) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);