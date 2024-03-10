package view;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Menu extends JanelaPadrao{

	public Menu() {
		adicionarLabels();
		adicionarButtons();
		setVisible(true);
	}
	

	private void adicionarLabels() {
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 50));
		lblMenu.setBounds(377, 22, 127, 92);
		getContentPane().add(lblMenu);
	}

	private void adicionarButtons() {
		JButton btnNewButton = new JButton("Cadastrar Livro");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(206, 210, 175, 65);
		btnNewButton.addActionListener(new OuvinteCadastrarLivro());
		getContentPane().add(btnNewButton);
		
		JButton btnListarLivros = new JButton("Listar Livros");
		btnListarLivros.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnListarLivros.setBounds(490, 210, 175, 65);
		getContentPane().add(btnListarLivros);
		btnListarLivros.addActionListener(new OuvinteListarLivro());
		setVisible(true);
	}
	
	
	private class OuvinteCadastrarLivro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new CadastrarLivro();			
		}
		
	}
	
	private class OuvinteListarLivro implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new ListarLivro();	
		}
		
	}
}
