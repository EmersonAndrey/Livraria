package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class CadastroADM extends JanelaPadrao{
	private JTextField campoEmail;
	private JPasswordField campoSenha;
	private JPasswordField campoSenha2;
	
	public CadastroADM() {
		adicionarLabels();
		adicionandoTexts();	
		adicionandoButtons();
		setVisible(true);
		
	}
	
	
	public void adicionandoButtons() {
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(450, 416, 119, 28);
		btnNewButton.addActionListener(new OuvinteBotaoConfirmar());
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirmar Senha:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(339, 315, 183, 28);
		getContentPane().add(lblNewLabel_1_1);
		
	}
	
	public void adicionandoTexts() {
		campoEmail = new JTextField();
		campoEmail.setBounds(339, 167, 230, 28);
		campoEmail.setColumns(10);
		getContentPane().add(campoEmail);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(339, 264, 230, 28);
		getContentPane().add(campoSenha);
		
		campoSenha2 = new JPasswordField();
		campoSenha2.setBounds(339, 353, 230, 28);
		getContentPane().add(campoSenha2);
	}
	
	public void adicionarLabels() {
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setBounds(347, 10, 209, 92);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 50));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(339, 129, 78, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(339, 226, 91, 28);
		getContentPane().add(lblNewLabel_1_1);
	}
	
	private class OuvinteBotaoConfirmar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (campoEmail.getText().isEmpty() || new String(campoSenha.getPassword()).isEmpty() 
					|| new String(campoSenha2.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
				
			}else if (!new String(campoSenha.getPassword()).equals(new String(campoSenha2.getPassword()))) {
				JOptionPane.showMessageDialog(null, "Campos de senha e confirmação de senha, devem coincidirem");
				
			}else {
				//Criar administrador e salva-lo
				dispose();
				new Login();
			}
			
		}
		
	}
	
	private class OuvinteMouseCampoSenha implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			campoSenha2.setText("");	
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		
	}
}
