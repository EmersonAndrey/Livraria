package view;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JButton;

public class ListarLivro extends JanelaPadrao{
	private JTable table;

	public ListarLivro() {
		adicionarbotoes();
		adicionarlabels();
		adicionartable();
		setVisible(true);	
	}
	

	private void adicionartable() {
		table = new JTable();
		table.setBounds(68, 112, 747, 261);
		getContentPane().add(table);
	}

	private void adicionarlabels() {
		JLabel lblListaDeLivros = new JLabel("Listagem");
		lblListaDeLivros.setFont(new Font("Trebuchet MS", Font.BOLD, 50));
		lblListaDeLivros.setBounds(349, 10, 210, 92);
		getContentPane().add(lblListaDeLivros);
	}

	private void adicionarbotoes() {
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVoltar.setBounds(68, 441, 119, 28);
		btnVoltar.addActionListener(new OuvinteBotaoVoltar());
		getContentPane().add(btnVoltar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRemover.setBounds(549, 441, 119, 28);
		getContentPane().add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditar.setBounds(696, 441, 119, 28);
		btnEditar.addActionListener(new OuvinteBotaoEditar());
		getContentPane().add(btnEditar);
	}
	
	private class OuvinteBotaoVoltar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new Menu();
			
		}
	}
	
	private class OuvinteBotaoRemover implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione uma linha para remover");
				
			}else {
				//remover
			}
			
		}
	}
	
	private class OuvinteBotaoEditar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione uma linha para editar");
				
			}else {
				new EditarLivro();
			}
			
		}
	}
}
