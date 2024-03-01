package app.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titulo;
	private String ISSN;
	private String sinopse;
	private int ano;
	private int numpag;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livro")
	private Biblioteca biblioteca;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "livro_autor")
	private List<Autor>autor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livro")
	private Editora editora;
}
