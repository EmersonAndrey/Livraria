package model;

import javax.persistence.Entity;
import javax.persistence.Id;

import dto.AdministradorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {

	@Id
	private String email;
	private String senha;
	
	public Administrador(AdministradorDTO dto) {
		this.email = dto.getEmail();
		this.senha = dto.getSenha();
	}
	
}
