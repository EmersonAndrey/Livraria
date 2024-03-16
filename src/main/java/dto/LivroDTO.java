package dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {	
	
	private String isbn;	
	private String titulo;		
	private String genero;		
	private String editora;		
	private String descricao;
	private int quantidade;
	
}
