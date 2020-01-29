package futdaalegria.futdaalegria.controller;

import futdaalegria.futdaalegria.model.Jogador;
import futdaalegria.futdaalegria.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/jogador")
public class JogadorController {

    @Autowired
    private JogadorRepository repository;

    @PostMapping
    public ResponseEntity<Void> salvarJogador(@Valid @RequestBody Jogador jogador){
        repository.save(jogador);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> buscarTodos(){
        return ResponseEntity.ok().body(repository.findAll());
    }
}
