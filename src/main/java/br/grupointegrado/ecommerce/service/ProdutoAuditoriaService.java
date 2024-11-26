package br.grupointegrado.ecommerce.service;

import br.grupointegrado.ecommerce.model.ProdutoAuditoria;
import br.grupointegrado.ecommerce.repository.ProdutoAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoAuditoriaService {
    @Autowired
    private ProdutoAuditoriaRepository produtoAuditoriaRepository;

    public List<ProdutoAuditoria> findAll() {
        return produtoAuditoriaRepository.findAll();
    }

    public ProdutoAuditoria save(ProdutoAuditoria produtoAuditoria) {
        return produtoAuditoriaRepository.save(produtoAuditoria);
    }

    public void delete(Long id) {
        produtoAuditoriaRepository.deleteById(id);
    }
}