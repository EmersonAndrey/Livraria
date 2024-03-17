package dao;

import java.util.List;

import dto.AdministradorDTO;
import model.Administrador;

public interface AdministradorInterfaceDAO {

	public boolean salvar(AdministradorDTO admDTO) throws Exception;
	public List<Administrador> buscarADM() throws Exception;
	
}
