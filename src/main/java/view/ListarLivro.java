package view;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.LivroController;
import model.Livro;
import utils.JLabelRenderer;

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
		btnRemover.addActionListener(new OuvinteBotaoRemover());
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
		tabelaModelo.addColumn("Título");
		tabelaModelo.addColumn("Gênero");
		tabelaModelo.addColumn("Editora");
		tabelaModelo.addColumn("Descrição");
		tabelaModelo.addColumn("Quantidade");
		
		
		
		table = new JTable(tabelaModelo);
		table.getColumn("Descrição").setCellRenderer(new JLabelRenderer()); 
		
		JScrollPane js = new JScrollPane(table);
		
		js.setBounds(68, 112, 747, 261);
		getContentPane().add(js);
		
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
			Object[] linha = new Object[6];
			
			linha[0] = livro.getIsbn();
			linha[1] = livro.getTitulo();
			linha[2] = livro.getGenero();
			linha[3] = livro.getEditora();
			
			JLabel desc = new JLabel(livro.getDescricao());
			desc.setToolTipText(livro.getDescricao());
			linha[4] = desc;
			
			linha[5] = livro.getQuantidade();
			
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
			int linhaSelecionada = table.getSelectedRow();
			
			if (linhaSelecionada == -1) {
				JOptionPane.showMessageDialog(null, "Selecione uma linha para remover");
				
			}else {
				Object isbn = table.getValueAt(linhaSelecionada, 0);
				System.out.println((String)isbn);
				
				try {
					LivroController.getInstance().deletar((String)isbn);
					JOptionPane.showMessageDialog(null, "Livro removido com sucesso");
					dispose();
					new ListarLivro();					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}
	}
	
	private class OuvinteBotaoEditar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = table.getSelectedRow();
			
			if (linhaSelecionada == -1) {
				JOptionPane.showMessageDialog(null, "Selecione uma linha para editar");
				
			}else {
				dispose();
				Object isbn = table.getValueAt(linhaSelecionada, 0);
				try {
					new EditarLivro(LivroController.getInstance().buscarLivroId((String)isbn));
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}
	}
}
