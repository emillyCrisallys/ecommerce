package br.grupointegrado.ecommerce.service;

import br.grupointegrado.ecommerce.model.Pagamento;
import br.grupointegrado.ecommerce.repository.PagamentoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

    public Pagamento findById(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public void delete(Long id) {
        pagamentoRepository.deleteById(id);
    }
}