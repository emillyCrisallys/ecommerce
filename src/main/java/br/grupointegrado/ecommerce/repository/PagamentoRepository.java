package br.grupointegrado.ecommerce.repository;

import br.grupointegrado.ecommerce.model.Pagamento;
import br.grupointegrado.ecommerce.model.MetodoPagamento;
import br.grupointegrado.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    List<Pagamento> findByPedido(Pedido pedido);

    List<Pagamento> findByMetodoPagamento(MetodoPagamento metodoPagamento);

}