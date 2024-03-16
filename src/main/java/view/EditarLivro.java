package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controller.LivroController;
import dto.LivroDTO;
import model.Livro;

public class EditarLivro {

	private Livro livroEditar;

	public EditarLivro(Livro livro) {
		livroEditar = livro;
		editarLivro();
	}

	private void editarLivro() {

		CadastrarLivro telaCadLivro = new CadastrarLivro();

		telaCadLivro.getTituloJanela().setText("Editar Livro");
		telaCadLivro.getTituloJanela().setBounds(304, 10, 291, 59);

		telaCadLivro.getTextIsbn().setText(livroEditar.getIsbn());
		telaCadLivro.getTextIsbn().setEnabled(false);

		telaCadLivro.getTextTitulo().setText(livroEditar.getTitulo());
		telaCadLivro.getTextEditora().setText(livroEditar.getEditora());
		telaCadLivro.getTextGenero().setText(livroEditar.getGenero());
		telaCadLivro.getTaDescricao().setText(livroEditar.getDescricao());
		telaCadLivro.getSpinnerQuantidade().setValue(livroEditar.getQuantidade());
		
		telaCadLivro.getBtConfirmar().setVisible(false);
		;
		
		JButton btConfirmar = new JButton("Atualizar");
		btConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btConfirmar.setBounds(698, 441, 119, 28);
		btConfirmar.addActionListener(new OuvinteConfirmarEdicao(telaCadLivro));
		telaCadLivro.add(btConfirmar);
		
	}

	private class OuvinteConfirmarEdicao implements ActionListener {

		private CadastrarLivro telaEditar;

		public OuvinteConfirmarEdicao(CadastrarLivro telaEditar) {
			this.telaEditar = telaEditar;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (telaEditar.getTextIsbn().getText().isEmpty() || telaEditar.getTextTitulo().getText().isEmpty()
					|| telaEditar.getTextGenero().getText().isEmpty() || telaEditar.getTextEditora().getText().isEmpty()
					|| telaEditar.getTaDescricao().getText().isEmpty()
					|| (int) telaEditar.getSpinnerQuantidade().getValue() <= 0) {
				JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos ou maior que 0");

			} else {
				try {
					LivroController.getInstance().editar(new LivroDTO(telaEditar.getTextIsbn().getText(),
									telaEditar.getTextTitulo().getText(), telaEditar.getTextGenero().getText(),
									telaEditar.getTextEditora().getText(),telaEditar.getTaDescricao().getText(),(int) telaEditar.getSpinnerQuantidade().getValue()));
					JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
					telaEditar.dispose();
					new Menu();
					
				} catch (Exception e2) {
					System.out.println("Error!");

				}
			}

		}

	}

}
