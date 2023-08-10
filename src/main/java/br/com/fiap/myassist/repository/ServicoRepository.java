package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByDescricaoIgnoreCase(String descricao);

    List<Servico> findByDescricaoIgnoreCaseAndIdNot(String descricao, Long id);

}
