package controller;

import java.util.List;

import dao.LivroDAO;
import dto.LivroDTO;
import model.Livro;

public class LivroController {
	
	private static volatile LivroController instance;
	private LivroDAO livroDAO =  new LivroDAO();
	
	
	
	
	private LivroController() {
		
	}
	
	public static LivroController getInstance() {
		if(instance == null) {
			synchronized (LivroController.class) {
				if(instance == null) {
					instance = new LivroController();					
				}
			}			
		}
		return instance;
	}
	
	
	
	
		
	public boolean salvar(LivroDTO livro) throws Exception{
		
		try {
			if(livroDAO.salvar(livro)) {
				return true;
			}
			
		} catch (Exception e) {
			throw e;
		}
		return false;
	
		
	}
	public boolean deletar(String ISBNlivro) throws Exception{
		
		try {
			if(livroDAO.deletar(ISBNlivro)) {
				return true;
			}
			
		} catch (Exception e) {			
			throw e;
		}
		return false;
		
	}
	public boolean editar(LivroDTO livro) throws Exception{
		
		try {			
			if(livroDAO.editar(livro)) {
				return true;
			}
			
		} catch (Exception e) {
			throw e;
		}
		return false;
		
	}
	
	public Livro buscarLivroId(String idLivro) throws Exception{
		
		try {
			return livroDAO.buscarLivroId(idLivro);
			
		} catch (Exception e) {
			throw e;
		}
			
	}
	
	public List<Livro> buscarTodos() throws Exception {	
		
		try {			
			return livroDAO.buscarTodos();
			
		} catch (Exception e) {
			throw e;
		}
			
	}
	
	public boolean isbnDuplicado(String isbnNovo) throws Exception{		
		
		try {
			
			for (Livro livro : buscarTodos()) {
				if(livro.getIsbn().equals(isbnNovo)) {
					return true;
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
		return false;
	}
}
