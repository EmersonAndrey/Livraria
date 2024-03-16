package main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import dao.LivroDAO;
import dto.LivroDTO;
import view.CadastrarLivro;
import view.CadastroADM;
import view.EditarLivro;
import view.ListarLivro;
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
		
		//verifica administrador tela cadastro ou login
		
		
		new Menu();
	}

}
