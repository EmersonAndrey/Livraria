package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.LivroController;
import dto.LivroDTO;

public class CadastrarLivro extends JanelaPadrao {

	private JTextField textIsbn;
	private JTextField textTitulo;
	private JTextField textGenero;
	private JTextField textEditora;
	private JTextArea taDescricao;

	private JSpinner spinnerQuantidade;

	private JLabel tituloJanela;
	
	private JButton btConfirmar;

	public CadastrarLivro() {
		adicionarspinner();
		adicionarbotoes();
		adicionarLabels();
		adicionarTexts();
		setVisible(true);
	}

	public JButton getBtConfirmar() {
		return btConfirmar;
	}

	public void setBtConfirmar(JButton btConfirmar) {
		this.btConfirmar = btConfirmar;
	}

	public JTextField getTextIsbn() {
		return textIsbn;
	}

	public void setTextIsbn(JTextField textIsbn) {
		this.textIsbn = textIsbn;
	}

	public JTextField getTextTitulo() {
		return textTitulo;
	}

	public void setTextTitulo(JTextField textTitulo) {
		this.textTitulo = textTitulo;
	}

	public JTextField getTextGenero() {
		return textGenero;
	}

	public void setTextGenero(JTextField textGenero) {
		this.textGenero = textGenero;
	}

	public JTextField getTextEditora() {
		return textEditora;
	}

	public void setTextEditora(JTextField textEditora) {
		this.textEditora = textEditora;
	}

	public JTextArea getTaDescricao() {
		return taDescricao;
	}

	public void setTaDescricao(JTextArea taDescricao) {
		this.taDescricao = taDescricao;
	}

	public JSpinner getSpinnerQuantidade() {
		return spinnerQuantidade;
	}

	public void setSpinnerQuantidade(JSpinner spinnerQuantidade) {
		this.spinnerQuantidade = spinnerQuantidade;
	}

	public JLabel getTituloJanela() {
		return tituloJanela;
	}

	public void setTituloJanela(JLabel tituloJanela) {
		this.tituloJanela = tituloJanela;
	}

	private void adicionarbotoes() {
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btConfirmar.setBounds(698, 441, 119, 28);
		btConfirmar.addActionListener(new OuvinteBotaoConfirmar());
		getContentPane().add(btConfirmar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVoltar.setBounds(41, 441, 119, 28);
		btnVoltar.addActionListener(new OuvinteBotaoVoltar());
		getContentPane().add(btnVoltar);

	}

	private void adicionarspinner() {
		spinnerQuantidade = new JSpinner();
		spinnerQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinnerQuantidade.setBounds(619, 227, 80, 28);
		getContentPane().add(spinnerQuantidade);
	}

	private void adicionarTexts() {
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(153, 160, 230, 28);
		getContentPane().add(textTitulo);

		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(153, 229, 230, 28);
		getContentPane().add(textGenero);

		textEditora = new JTextField();
		textEditora.setColumns(10);
		textEditora.setBounds(153, 297, 230, 28);
		getContentPane().add(textEditora);
		JScrollPane painel = new JScrollPane();
		painel.setBounds(587, 303, 230, 94);
		getContentPane().add(painel);

		taDescricao = new JTextArea();
		painel.setViewportView(taDescricao);
		taDescricao.setLineWrap(true);
		taDescricao.setWrapStyleWord(true);

		textIsbn = new JTextField();
		textIsbn.setColumns(10);
		textIsbn.setBounds(531, 160, 230, 28);
		getContentPane().add(textIsbn);

	}

	private void adicionarLabels() {
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Descrição:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1_2_1.setBounds(451, 295, 135, 35);
		getContentPane().add(lblNewLabel_1_1_2_1);

		JLabel lblNewLabel_1_2 = new JLabel("ISBN:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(451, 160, 80, 28);
		getContentPane().add(lblNewLabel_1_2);

		tituloJanela = new JLabel("Cadastrar Livro");
		tituloJanela.setFont(new Font("Trebuchet MS", Font.BOLD, 50));
		tituloJanela.setBounds(255, 10, 362, 59);
		getContentPane().add(tituloJanela);

		JLabel lblNewLabel_1 = new JLabel("Titulo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(63, 160, 80, 28);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Editora:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(41, 295, 102, 35);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Gênero:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1_1.setBounds(41, 229, 102, 28);
		getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Quantidade:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1_2.setBounds(451, 222, 160, 35);
		getContentPane().add(lblNewLabel_1_1_2);
	}

	private class OuvinteBotaoVoltar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new Menu();

		}

	}

	private class OuvinteBotaoConfirmar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String isbn = textIsbn.getText();
			String titulo = textTitulo.getText();
			String genero = textGenero.getText();
			String editora = textEditora.getText();
			String desc = taDescricao.getText();
			int qtd = (int)spinnerQuantidade.getValue();
			
			if (isbn.isEmpty() || titulo.isEmpty() || genero.isEmpty() || editora.isEmpty() || desc.isEmpty() || qtd <= 0) {
				JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos ou maior que 0");
				
			}else {
				try {
					if(!LivroController.getInstance().isbnDuplicado(isbn)) {
						LivroController.getInstance().salvar(new LivroDTO(isbn, titulo, genero, editora, desc, qtd));
						JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
						
					}else {						
						JOptionPane.showMessageDialog(null, "Livro com ISBN indicado já existe!"
								+ "Altere o ISBN, e tente novamente.");
					}		
					dispose();
					new Menu();
					
				} catch (Exception e2) {					
					System.out.println("Error!");
					
				}
			}
				
			

		}
	}
}
