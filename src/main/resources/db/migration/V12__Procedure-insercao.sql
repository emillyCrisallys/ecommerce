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