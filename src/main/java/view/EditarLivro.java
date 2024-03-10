package view;

import javax.swing.JLabel;

public class EditarLivro {

	public EditarLivro() { //passa aq livro
		editarLivro(); // joga ele pra ca
	}

	private void editarLivro() { // joga ele praq pra manipulalo
		
		CadastrarLivro telaCadLivro = new CadastrarLivro();
		
		telaCadLivro.getTituloJanela().setText("Editar Livro");
		telaCadLivro.getTituloJanela().setBounds(304, 10, 291, 59);
		
		telaCadLivro.getTextTitulo().setEnabled(false);
		
		// colocar todos os texts com os valores do livro que chegar
		//pode mudar tudo menos o titulo(ele vai ser o identificador(PK))
	}
	
	
}
