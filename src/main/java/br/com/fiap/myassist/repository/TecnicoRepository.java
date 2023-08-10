package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.OrdemServico;
import br.com.fiap.myassist.entity.Servico;
import br.com.fiap.myassist.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

    List<Tecnico> findByNomeIgnoreCase(String nome);

    List<Tecnico> findByNomeIgnoreCaseAndIdNot(String nome, Long id);

   /* @Query("Select os from OrdemServico os where os.responsavel.id = :idTecnico")
    List<OrdemServico> findOrdensServico(Long idTecnico);*/

}
