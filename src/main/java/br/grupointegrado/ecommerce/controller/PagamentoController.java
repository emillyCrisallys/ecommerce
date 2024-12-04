package br.grupointegrado.ecommerce.controller;

import br.grupointegrado.ecommerce.dto.PagamentoRequestDTO;
import br.grupointegrado.ecommerce.model.MetodoPagamento;
import br.grupointegrado.ecommerce.model.Pagamento;
import br.grupointegrado.ecommerce.model.Pedido;
import br.grupointegrado.ecommerce.repository.MetodoPagamentoRepository;
import br.grupointegrado.ecommerce.repository.PagamentoRepository;
import br.grupointegrado.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private MetodoPagamentoRepository metodoPagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<Pagamento>> getAll() {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> getById(@PathVariable Integer id) {
        return pagamentoRepository.findById(id)
                .map(pagamento -> ResponseEntity.ok(pagamento))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pagamento> create(@RequestBody PagamentoRequestDTO dto) {
        MetodoPagamento metodoPagamento = metodoPagamentoRepository.findById(dto.metodoPagamentoId())
                .orElseThrow(() -> new RuntimeException("Método de pagamento não encontrado"));


        Pedido pedido = new Pedido();

                Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setMetodoPagamento(metodoPagamento);
        pagamento.setValor(dto.valor());

        Pagamento savedPagamento = pagamentoRepository.save(pagamento);
        return ResponseEntity.status(201).body(savedPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> update(@PathVariable Integer id, @RequestBody PagamentoRequestDTO dto) {
        return pagamentoRepository.findById(id)
                .map(existingPagamento -> {
                    MetodoPagamento metodoPagamento = metodoPagamentoRepository.findById(dto.metodoPagamentoId())
                            .orElseThrow(() -> new RuntimeException("Método de pagamento não encontrado"));


                    Pedido pedido = pedidoRepository.findById(dto.pedidoId())
                            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

                    existingPagamento.setPedido(pedido);
                    existingPagamento.setMetodoPagamento(metodoPagamento);
                    existingPagamento.setValor(dto.valor());

                    Pagamento updatedPagamento = pagamentoRepository.save(existingPagamento);
                    return ResponseEntity.ok(updatedPagamento);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return pagamentoRepository.findById(id)
                .map(existingPagamento -> {
                    pagamentoRepository.delete(existingPagamento);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}