package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {


    List<OrdemServico> findByDataEntradaBetween(LocalDateTime dataInicio, LocalDateTime dataFim);

}
