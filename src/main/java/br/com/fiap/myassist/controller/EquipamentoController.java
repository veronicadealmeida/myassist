package br.com.fiap.myassist.controller;

import br.com.fiap.myassist.entity.Servico;
import br.com.fiap.myassist.enums.TipoEquipamentoEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EquipamentoController {


    @GetMapping("/tipos")
    public List<TipoEquipamentoEnum> findTipos() {
        return List.of(TipoEquipamentoEnum.values());
    }

}
