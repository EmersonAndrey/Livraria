package model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import dto.LivroDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Livro {	
	
	@Id
	@Column(name = "ISBN")
	private String isbn;
	
	@Column(name = "Titulo")
	private String titulo;
	
	@Column(name = "Genero")
	private String genero;
	
	@Column(name = "Genero")
	private String editora;
	
	@Column(name ="Descricao")
	private String descricao;
	
	@Column(name = "Quantidade")
	private int quantidade;
	
	public Livro(LivroDTO livro) {
		
		this.isbn = livro.getIsbn();
		this.titulo = livro.getTitulo();
		this.genero = livro.getGenero();
		this.editora = livro.getEditora();
		this.descricao = livro.getDescricao();
		this.quantidade = livro.getQuantidade();
		
	}
	
	
}
