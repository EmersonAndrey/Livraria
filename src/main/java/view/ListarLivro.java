package view;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.LivroController;
import model.Livro;

public class ListarLivro extends JanelaPadrao{
	private JTable table;
	private DefaultTableModel tabelaModelo;

	public ListarLivro() {
		adicionarbotoes();
		adicionarlabels();
		adicionarTabela();
		setVisible(true);	
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
	
	public void adicionarTabela() {
		tabelaModelo = new DefaultTableModel();
		tabelaModelo.addColumn("ISBN");
		tabelaModelo.addColumn("Titulo");
		tabelaModelo.addColumn("Quantidade");
		
		table = new JTable(tabelaModelo);
		JScrollPane js = new JScrollPane(table);
		
		table.setBounds(68, 112, 747, 261);
		getContentPane().add(table);
		
		List<Livro> todosLivros = null; 
		try {
			todosLivros = LivroController.getInstance().buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		preencherTabela(todosLivros);		
	}
	
	public void preencherTabela(List<Livro> listaLivros) {
		
		limparTabela(tabelaModelo, table);
		
		for (Livro livro : listaLivros) {			
			Object[] linha = new Object[3];
			
			linha[0] = livro.getIsbn();
			linha[1] = livro.getTitulo();
			linha[2] = livro.getQuantidade();
			
			tabelaModelo.addRow(linha);
			
		}
	}
	
	private void limparTabela(DefaultTableModel modelo, JTable tabela) {
		int cont = modelo.getRowCount();
		for (int i = 0; i < cont; i++) {
			modelo.removeRow(0);
		}
		tabela.repaint();
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
