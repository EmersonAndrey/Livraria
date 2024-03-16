package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dto.LivroDTO;
import model.Livro;

public class LivroDAO implements LivroInterfaceDAO{
	

	@Override
	public boolean salvar(LivroDTO livro) throws Exception{
			
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjeto");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(new Livro(livro));
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			return true;
			
		}catch (Exception e) {			
			throw e;
			
		}
	}

	@Override
	public boolean deletar(String ISBNlivro) throws Exception {
		
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjeto");
			EntityManager em = emf.createEntityManager();
			
			Livro livroExistente = buscarLivroId(ISBNlivro); 
			
			if(livroExistente != null) {
				em.getTransaction().begin();
				em.remove(em.contains(livroExistente) ? livroExistente : em.merge(livroExistente));
				em.getTransaction().commit();
				em.close();
				emf.close();
				
				return true;
				
			}		
			
		} catch (Exception e) {
			throw e;
			
		}
		return false;
		
		
	}

	@Override
	public boolean editar(LivroDTO livro) throws Exception{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjeto");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.merge(new Livro(livro));
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			throw e;
			
		}finally {
			em.close();
			emf.close();
		}
		 
		
	}

	@Override
	public Livro buscarLivroId(String idLivro) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjeto");
		EntityManager em = emf.createEntityManager();
		try {
			
			
			return em.find(Livro.class, idLivro);
			
		} catch (Exception e) {
			throw e;
			
		}finally {
			em.close();
			emf.close();
		}
		 
		
	}

	@Override
	public List<Livro> buscarTodos() throws Exception{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjeto");
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Livro> todosLivros = em.createQuery("FROM Livro l", Livro.class);
			return todosLivros.getResultList();
			
		} catch(Exception e) {
			throw e;
			
		}finally {
			em.close();
			emf.close();
		}
		
		
	}

}
