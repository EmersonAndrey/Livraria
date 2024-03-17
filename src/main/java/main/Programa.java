package main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import org.postgresql.jdbc.EscapedFunctions;

import controller.AdministradorController;
import dao.LivroDAO;
import dto.LivroDTO;
import model.Administrador;
import view.CadastrarLivro;
import view.CadastroADM;
import view.EditarLivro;
import view.ListarLivro;
import view.Login;
import view.Menu;

public class Programa {

	public static void main(String[] args) {
	
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
		
		try {
			if (AdministradorController.getInstance().buscarADM().size() > 0) {
				new Login();
				
			} else {
				new CadastroADM();
			}
			
		} catch(Exception e) {
			System.out.println("Error!");
		}
		
	}

}
