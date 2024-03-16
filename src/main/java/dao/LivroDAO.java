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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjeto");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(new Livro(livro));
			em.getTransaction().commit();
			return true;
			
		}catch (Exception e) {			
			throw e;
			
		}finally {
			em.close();
			emf.close();
		}
	}

	@Override
	public boolean deletar(LivroDTO livro) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjeto");
		EntityManager em = emf.createEntityManager();
		
		try {
			
			Livro livroExistente = buscarLivroId(livro.getIsbn()); 
			
			if(livroExistente != null) {
				em.getTransaction().begin();
				em.remove(livroExistente);
				em.getTransaction().commit();
				return true;
				
			}		
			
		} catch (Exception e) {
			throw e;
			
		}finally {
			em.close();
			emf.close();
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
	public List<Livro> buscarTodos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LivrariaProjeto");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Livro> todosLivros = em.createQuery("FROM Livro l", Livro.class);
		
		em.close();
		emf.close();
		
		return todosLivros.getResultList();
	}

}
