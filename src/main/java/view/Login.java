package view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login extends JanelaPadrao {
	private JTextField campoEmail;
	private JPasswordField campoSenha;

	
	public Login() {		
		adicionarLabels();
		adicionandoTexts();	
		adicionandoButtons();
		setVisible(true);
	}
	
	
	public void adicionandoButtons() {
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(484, 377, 119, 28);
		btnNewButton.addActionListener(new OuvinteBotaoConfirmar());
		getContentPane().add(btnNewButton);
	}
	
	public void adicionandoTexts() {
		campoEmail = new JTextField();
		campoEmail.setBounds(394, 195, 209, 28);
		getContentPane().add(campoEmail);
		campoEmail.setColumns(10);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(394, 301, 209, 28);
		getContentPane().add(campoSenha);
	}
	
	public void adicionarLabels() {
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(387, 10, 127, 92);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 50));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(285, 195, 99, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(278, 301, 106, 28);
		getContentPane().add(lblNewLabel_1_1);	
	}
	
	
	private class OuvinteBotaoConfirmar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (campoEmail.getText().isEmpty() || new String(campoSenha.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
				
			}//else if () {
//				verificar coincide adm cadastrado
//				
			else {
				dispose();
				new Menu();
			}
			
		}
		
	}
}
