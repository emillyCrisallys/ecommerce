DELIMITER //
CREATE TRIGGER produto_auditoria
AFTER UPDATE ON produto
FOR EACH ROW
BEGIN
    INSERT INTO produto_auditoria (produto_id, valor_antigo, valor_novo, data_alteracao)
    VALUES (OLD.id, OLD.preco, NEW.preco, NOW());
END //
DELIMITER ;