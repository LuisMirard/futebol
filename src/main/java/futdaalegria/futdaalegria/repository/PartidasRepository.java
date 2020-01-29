package futdaalegria.futdaalegria.repository;

import futdaalegria.futdaalegria.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidasRepository extends JpaRepository<Partida, Integer> {

    Partida findByStatus(String status);

}
