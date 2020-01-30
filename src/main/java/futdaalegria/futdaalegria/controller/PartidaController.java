package futdaalegria.futdaalegria.controller;

import futdaalegria.futdaalegria.model.Partida;
import futdaalegria.futdaalegria.repository.PartidasRepository;
import futdaalegria.futdaalegria.service.OrganizarPartida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/partida")
public class PartidaController {

    @Autowired
    private PartidasRepository repository;

    @Autowired
    private OrganizarPartida organizarPartida;

    @PostMapping
    public ResponseEntity<Void> salvarPartida(@Valid @RequestBody Partida partida){
        repository.save(partida);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<Partida> buscaPorStatusAtiva(){
        return ResponseEntity.ok().body(repository.findByStatus("ATIVA"));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Partida>> buscaTodas(){
        return ResponseEntity.ok().body(repository.findAll());
    }


    @PostMapping(path = "/sorteio")
    public ResponseEntity<Partida> sorteio(@Valid @RequestBody Partida partida){
        return ResponseEntity.ok().body(organizarPartida.sorteio(partida));
    }

}
