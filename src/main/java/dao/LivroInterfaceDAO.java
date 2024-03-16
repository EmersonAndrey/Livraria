package dao;


import java.util.List;

import dto.LivroDTO;
import model.Livro;

public interface LivroInterfaceDAO {
	

	public boolean salvar(LivroDTO livro) throws Exception;
	public boolean deletar(LivroDTO livro) throws Exception;
	public boolean editar(LivroDTO livro) throws Exception;
	public Livro buscarLivroId(String idLivro) throws Exception;
	public List<Livro> buscarTodos() throws Exception;
	
}
