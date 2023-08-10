package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.entity.Servico;
import br.com.fiap.myassist.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    public List<Servico> listarTodos() {
        return servicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id) {
        var result = servicoRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PostMapping
    public ResponseEntity<Servico> inserir(@RequestBody Servico servico) {
        var exists = servicoRepository.findByDescricaoIgnoreCase(servico.getDescricao());
        if (exists.isEmpty()) {
            Servico saved = servicoRepository.save(servico);
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long id,
                                             @RequestBody Servico servico) {
        var exists = servicoRepository.findByDescricaoIgnoreCaseAndIdNot(servico.getDescricao(), id);
        if (!exists.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if (!servicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        var updated = servicoRepository.save(servico);
        return ResponseEntity.ok(updated);
    }

}
