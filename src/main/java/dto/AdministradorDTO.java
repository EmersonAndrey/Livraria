package dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Administrador;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorDTO {

	private String email;
	private String senha;
	
	public AdministradorDTO(Administrador adm) {
		this.email = adm.getEmail();
		this.senha = adm.getSenha();
	}
	
}
