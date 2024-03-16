package model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

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
	private String isbn;
	
	private String titulo;
	private String genero;
	private String editora;
	private String descricao;
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
