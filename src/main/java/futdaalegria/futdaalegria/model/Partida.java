package futdaalegria.futdaalegria.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_partida")
@Getter @Setter
public class Partida implements Serializable {

	private static final long serialVersionUID = 3996922219502780593L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "local")
	private String local;

	@Column(name = "data_hora_partida")
	private Date dataHoraPartida;

	@Column(name = "data_hora_limite_confirmacao")
	private Date dataHoraLimite;

	@Column(name = "numero_time")
	private Integer numeroTimes;

	@Column(name = "jogadores")
	private String jogadores;

	@Column(name = "times")
	private String times;

	@Column(name = "pagadores")
	private String pagadores;

	@Column(name = "status")
	private String status;

}
