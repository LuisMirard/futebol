package futdaalegria.futdaalegria.service;


import futdaalegria.futdaalegria.model.Partida;
import futdaalegria.futdaalegria.repository.PartidasRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrganizarPartida {

    @Autowired
    private PartidasRepository repository;

    public Partida sorteio(Partida partida){
        List<String> listaJogadores = Arrays.asList(Strings.isNotEmpty(partida.getJogadores()) ? partida.getJogadores().split(",") : null);
        int quantidadeJogadoresPorTime = listaJogadores.size() / partida.getNumeroTimes() ;

        int repetidor = new Random().nextInt(100);
        int count = 0;
        while(count < repetidor){
            Collections.shuffle(listaJogadores);
            count++;
        }
        String time = "";
        Set sorteados = new HashSet();
        int contadorTime = 1;
        for (String play : listaJogadores){
            sorteados.add(play.toUpperCase());
            if (sorteados.size() == quantidadeJogadoresPorTime) {
                time = time + "TIME " + contadorTime + "->" + String.join(",", sorteados) + "\r\n";
                sorteados = new HashSet();
                contadorTime++;
            }
        }
        partida.setTimes(time);

        repository.save(partida);

        return partida;
    }
}