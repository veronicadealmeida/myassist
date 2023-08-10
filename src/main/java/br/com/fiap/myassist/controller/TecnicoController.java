package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.entity.Tecnico;
import br.com.fiap.myassist.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @GetMapping
    public List<Tecnico> listarTodos() {
        return tecnicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Long id) {
        var result = tecnicoRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PostMapping
    public ResponseEntity<Tecnico> inserir(@RequestBody Tecnico tecnico) {
        var exists = tecnicoRepository.findByNomeIgnoreCase(tecnico.getNome());
        if (exists.isEmpty()) {
            Tecnico saved = tecnicoRepository.save(tecnico);
            return ResponseEntity.ok(saved);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> update(@PathVariable Long id,
                                          @RequestBody Tecnico tecnico) {
        var exists = tecnicoRepository.findByNomeIgnoreCaseAndIdNot(tecnico.getNome(), id);
        if (!exists.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if (!tecnicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        var updated = tecnicoRepository.save(tecnico);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tecnico> delete(@PathVariable Long id) {
        var result = tecnicoRepository.findById(id);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        /*var exists = tecnicoRepository.findOrdensServico(id);
        if (!exists.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }*/

        tecnicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
