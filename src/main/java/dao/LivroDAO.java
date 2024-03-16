package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dto.LivroDTO;
import model.Livro;

public class LivroDAO implements LivroInterfaceDAO{
	
	 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livraria");
	private EntityManager em = emf.createEntityManager(); 

	@Override
	public boolean salvar(LivroDTO livro) throws Exception{
		
		
		
		try {
			//iniciarConexao();
			em.getTransaction().begin();
			em.persist(new Livro(livro));
			em.getTransaction().commit();
			
			return true;
			
		}catch (Exception e) {			
			System.out.println("Estou aqui no DAO");;
			
		}finally {
			fecharConexao();			
		}
		return false;
	}

	@Override
	public boolean deletar(LivroDTO livro) throws Exception {
		
		try {
			
			Livro livroExistente = buscarLivroId(livro.getIsbn()); 
			
			if(livroExistente != null) {
				iniciarConexao();
				em.getTransaction().begin();
				em.remove(livroExistente);
				em.getTransaction().commit();
				return true;
				
			}		
			
		} catch (Exception e) {
			throw e;
			
		}finally {
			fecharConexao();
		}
		return false;
		
		
	}

	@Override
	public boolean editar(LivroDTO livro) throws Exception{
		
		try {
			iniciarConexao();
			em.getTransaction().begin();
			em.merge(new Livro(livro));
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			throw e;
			
		}finally {
			fecharConexao();
		}
		
		 
		
	}

	@Override
	public Livro buscarLivroId(String idLivro) throws Exception {
		
		try {
			iniciarConexao();
			return em.find(Livro.class, idLivro);
			
		} catch (Exception e) {
			throw e;
			
		}finally {
			fecharConexao();
		}
		 
		
	}

	@Override
	public List<Livro> buscarTodos() {
		
		TypedQuery<Livro> todosLivros = em.createQuery("FROM Livro l", Livro.class);	
		 
		return todosLivros.getResultList();
		
	}
	
	private void iniciarConexao() {
		emf = Persistence.createEntityManagerFactory("Livraria");
		em = emf.createEntityManager();
	}
	
	private void fecharConexao() {
		em.close();
		emf.close();
	}

}
