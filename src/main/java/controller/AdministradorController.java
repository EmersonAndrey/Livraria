package controller;

import java.util.List;

import dao.AdministradorDAO;
import dto.AdministradorDTO;
import model.Administrador;

public class AdministradorController {

	private static volatile AdministradorController instance;
	private AdministradorDAO administradorDAO = new AdministradorDAO();

	private AdministradorController() {

	}

	public static AdministradorController getInstance() {
		if (instance == null) {
			synchronized (AdministradorController.class) {
				if (instance == null) {
					instance = new AdministradorController();
				}
			}
		}
		return instance;
	}

	public boolean salvarADM(AdministradorDTO adm) throws Exception {

		try {
			if (administradorDAO.salvar(adm)) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public List<Administrador> buscarADM() throws Exception {

		try {
			return administradorDAO.buscarADM();

		} catch (Exception e) {
			throw e;
		}

	}
}
