package br.edu.utfpr.pb.atividade2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O campo 'titulo' deve ser preenchido!")
	@Column(length = 254, nullable = false)
	private String nome;
	
	@NotNull(message = "O campo 'editora' deve ser preenchido!")
	@ManyToOne
	@JoinColumn(name = "editora_id", referencedColumnName = "id")
	private Editora editora;
	
	@NotNull(message = "O campo 'genero' deve ser preenchido!")
	@ManyToOne
	@JoinColumn(name = "genero_id", referencedColumnName = "id")
	private Genero genero;
	
	@NotNull(message = "O campo 'autor' deve ser preenchido!")
	@ManyToOne
	@JoinColumn(name = "autor_id", referencedColumnName = "id")
	private Autor autor;
	
	@NotEmpty(message = "O campo 'ano' deve ser preenchido!")
	@Column(nullable = false)
	private Long ano;
	
	@NotEmpty(message = "O campo 'isbn' deve ser preenchido!")
	@Column(length = 10, nullable = false)
	private Long isbn;
	
	@NotNull(message = "O campo 'cidade' deve ser preenchido!")
	@ManyToOne
	@JoinColumn(name = "cidade_id", referencedColumnName = "id")
	private Cidade cidade;
	
	@NotEmpty(message = "O campo 'valor' deve ser preenchido!")
	@Column(nullable = false)
	private Double valor;
	
	
	
}