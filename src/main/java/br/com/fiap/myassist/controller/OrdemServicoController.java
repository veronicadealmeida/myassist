package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.entity.Cliente;
import br.com.fiap.myassist.entity.OrdemServico;
import br.com.fiap.myassist.enums.PrioridadeExecucaoEnum;
import br.com.fiap.myassist.enums.StatusExecucaoEnum;
import br.com.fiap.myassist.repository.ClienteRepository;
import br.com.fiap.myassist.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordens-servico")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<OrdemServico> listarTodos() {
        return ordemServicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> findById(@PathVariable Long id) {
        var result = ordemServicoRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PostMapping
    public ResponseEntity<OrdemServico> inserir(@RequestBody OrdemServico ordemServico) {
        Optional<Cliente> existe = clienteRepository.findByNomeIgnoreCase(ordemServico.getCliente().getNome());
        if (existe.isPresent()) {
            ordemServico.setCliente(existe.get());
        }
        OrdemServico saved = ordemServicoRepository.save(ordemServico);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> atualizar(@PathVariable Long id,
                                                  @RequestBody OrdemServico ordemServico) {
        if (!ordemServicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        var updated = ordemServicoRepository.save(ordemServico);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/status")
    public List<StatusExecucaoEnum> findTipos() {
        return List.of(StatusExecucaoEnum.values());
    }

    @GetMapping("/prioridades")
    public List<PrioridadeExecucaoEnum> findPrioridades() {
        return List.of(PrioridadeExecucaoEnum.values());
    }

}
