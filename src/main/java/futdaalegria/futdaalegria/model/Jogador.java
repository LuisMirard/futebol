package futdaalegria.futdaalegria.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_jogador")
@Getter @Setter
public class Jogador implements Serializable {

	private static final long serialVersionUID = 3996922219502780593L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "nome")
	private String nome;

}
